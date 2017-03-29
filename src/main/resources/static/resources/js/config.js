requirejs.config({
    baseUrl: window.jsHostLocation + '/resources/js',
    paths: {
        jquery: 'https://code.jquery.com/jquery-3.1.1.min',
        stomp: 'https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp'
    }
});
var modules = [];

if (typeof jQuery == 'undefined') {
    modules.push('jquery');
}
modules.push("stomp");
// Do not chnage SockJS, because local SockJS has simple changes for working with requireJS.
modules.push("sockjs");
modules.push("adviser_main");
requirejs(modules, function () {
    InnopolisAdviser.jsHostLocation = jsHostLocation;
    InnopolisAdviser.init();
});








