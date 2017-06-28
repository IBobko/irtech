requirejs.config({
    baseUrl: window.jsHostLocation + '/resources/js',
    paths: {
        jquery: 'https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min',
        stomp: 'https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp',
        jquerymobile: 'https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min'
    }
});
var modules = [];

if (typeof jQuery == 'undefined') {
    modules.push('jquery');
}
modules.push("jquerymobile");
modules.push("stomp");
// Do not chnage SockJS, because local SockJS has simple changes for working with requireJS.
modules.push("sockjs");
modules.push("adviser_main");
requirejs(modules, function () {
    InnopolisAdviser.jsHostLocation = jsHostLocation;
    InnopolisAdviser.init();
});