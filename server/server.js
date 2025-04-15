const koa = require("koa");
const Router = require("@koa/router");
const session = require("koa-session");
const passport = require("koa-passport");
const GoogleStrategy = require("passport-google-oauth20").Strategy;
require("dotenv").config();

const app = new koa();
const router = new Router();

app.keys = [process.env.SESSION_SECRET];

const config = {
  key: "koa:sess", // default "koa.sess"
  maxAge: 96400000, // in milliseconds
  autoCommit: true, // automatically commit headers (default true)
  overwrite: true, // can overwrite or not (default true)
  httpOnly: true, // httpOnly or not (default true)
  signed: true, // signed or not (default true)
  rolling: false, // force a session identifier cookie to be set on every response. (default: false)
  renew: true, // renew session when session is nearly expired, but use original maxAge (default: false)
  secure: true, // true only works in https (default: false)
  sameSite: null, // session cookie sameSite options (default null, don't set it)
  domain: "null", // domain for set cookie (default null)
};

app.use(session(config, app)); // enable session support

app.use(passport.initialize());
app.use(passport.session());

passport.serializeUser((user, done) => {
  done(null, user);
});

passport.deserializeUser((user, done) => {
  done(null, user);
});

passport.use(
  new GoogleStrategy(
    {
      clientID: process.env.GOOGLE_CLIENT_ID,
      clientSecret: process.env.GOOGLE_CLIENT_SECRET,
      callbackURL: "http://localhost:3000/auth/google/callback",
    },
    (accessToken, refreshToken, profile, done) => {
      // save the user info to the database
    }
  )
);

function ensureAuthenticatedUser(ctx, next) {
  if (ctx.isAuthenticated()) {
    return next();
  } else {
    ctx.redirect("/login");
  }
}

//define the routes

router.get("/", (ctx) => {
  ctx.body =
    'Welcome to the Koa server! <a href="/auth/google">Login with Google</a>';
});

router.get("/auth/google", (ctx) => {
  passport.authenticate("google", { scope: ["profile", "email"] });
});

router.get(
  "/auth/google/callback",
  passport.authenticate("google", {
    successRedirect: "/protected",
    failureRedirect: "/login",
  })
);

router.get("/protected", ensureAuthenticatedUser, (ctx) => {
  ctx.body = `Welcome ${ctx.state.user.displayName}! to the protected route!`;
});

router.get("/login", (ctx) => {
  ctx.body = "Login failed. <a href='/auth/google'>You need to try again</a>";
});

router.get("/logout", (ctx) => {
  ctx.logout();
  ctx.redirect("/");
});

app.use(router.routes()).use(router.allowedMethods());

app.use((ctx) => {
  if (ctx.path === "/") {
    let counter = ctx.session.views || 0;
    ctx.session.views = ++counter;
    ctx.body = `You have visited this page ${counter} times`;
  }
});

app.listen(3000, () => {
  console.log("Server running on http://localhost:3000");
});
