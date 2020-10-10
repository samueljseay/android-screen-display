### screen-display: a full screen webview for wall displays

#### Intro

The idea of this is to build a simple Android app that lets you use devices such as the X96S Android smart stick
as a wall display without any distracting chrome around your browser window.

The app renders a webview with no chrome or title bars or anything to distract from what you want to present.
This lets you build full screen web apps to display on the smart stick, letting you build
any kind of smart display setup you want on a low budget.

At the moment this app is not available on the App Store so you'll need to package the APK
and install it manually yourself if you want to use it. You'll also need to set the url
to display manually at the moment. Check out the `MainActivity.kt` to set it.

TODO - add a UI screen where you can configure options on what URL to display and other relevant
settings.

If you have any suggestions please do raise an issue.

#### Note

This is a work in progress, you must hardcode the website URL currently.
