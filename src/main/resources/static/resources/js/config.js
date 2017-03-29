var jsName = "adviser2.js";

function getLocation(href) {
    var match = href.match(/^(https?\:)\/\/(([^:\/?#]*)(?:\:([0-9]+))?)([\/]{0,1}[^?#]*)(\?[^#]*|)(#.*|)$/);
    return match && {
            protocol: match[1],
            host: match[2],
            hostname: match[3],
            port: match[4],
            pathname: match[5],
            search: match[6],
            hash: match[7]
        }
}

var scripts = document.getElementsByTagName("script");

for (var index in scripts) {
    if (scripts[index].src != undefined && scripts[index].src.indexOf(jsName) != -1) {
        var loc = getLocation(scripts[index].src);
        var jsHostLocation = loc.protocol + "//" + loc.host;

        requirejs.config({
            baseUrl: jsHostLocation + '/resources/js',
            paths: {
                jquery: 'https://code.jquery.com/jquery-3.1.1.min',
                stomp: 'https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp',
                sockjs: 'https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.2/sockjs'
            }
        });

        var modules = [];

        if (typeof jQuery == 'undefined') {
            modules.push('jquery');
        }

        modules.push("sockjs");
        modules.push("stomp");

        modules.push("adviser");


        requirejs(modules, function () {
            InnopolisAdviser.jsHostLocation = jsHostLocation;
            InnopolisAdviser.init();
        });


        break;
    }
}






