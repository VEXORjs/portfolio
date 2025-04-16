import koa from "koa";
import Router from "@koa/router";
import passport from "koa-passport";


const app = new koa();
const router = new Router({
  prefix: "/",
});

router.get("/", (ctx) => {
  ctx.type = "text/html";
  ctx.body =
    "Welcome to the Koa server! <a href='/auth/google'>Login with Google</a>";
});

router.get(
  "/auth/google",
  passport.authenticate("google", { scope: ["profile", "email"] })
);

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
  ctx.type = "text/html";
  ctx.body = ctx.redirect("/protected");
});

router.get("/logout", (ctx) => {
  ctx.logout();
  ctx.redirect("/");
});

app.use(router.routes()).use(router.allowedMethods());
