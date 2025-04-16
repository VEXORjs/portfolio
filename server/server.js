import koa from "koa";
import session from "koa-session"; // Ensure this is correctly imported
import passport from "koa-passport";
import { Strategy as GoogleStrategy } from "passport-google-oauth20";
import favicon from "koa-favicon";
import "dotenv/config";
import { join } from "path";
import path from "path";
import { fileURLToPath } from "url";

const __filename = fileURLToPath(import.meta.url);
const __dirname = path.dirname(__filename);
const app = new koa();

const faviconPath = join(__dirname, "./client", "favicon.ico");

app.use(favicon(faviconPath)); // Ensure the path is correct

app.keys = [process.env.SESSION_SECRET];

const config = {
  key: "koa:sess",
  maxAge: "session",
  autoCommit: true,
  overwrite: true,
  httpOnly: false,
  signed: true,
  rolling: false,
  renew: true,
  secure: false, // Ensure your app is running on HTTPS if secure is true
};

app.use(session(config, app)); // Ensure this line is correct

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
      clientID: process.env.CLIENT_ID,
      clientSecret: process.env.CLIENT_SECRET,
      callbackURL: "http://localhost:3000/auth/google/callback",
    },
    (accessToken, refreshToken, profile, done) => {
      // save the user info to the database
      return done(null, profile);
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
