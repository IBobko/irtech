/**
 * Generates bubble chart graphic from flare.csv file (some fake data)
 * @return no return value, generated graph is places in svg
 */
function bubble_chart() {

    $("#svg").empty();

    var svg = d3.select("svg"),
            width = +document.getElementById('dashboard').offsetWidth,
            height = +document.getElementById('dashboard').offsetWidth;

    var format = d3.format(",d");

    var color = d3.scaleOrdinal(d3.schemeCategory20c);

    var pack = d3.pack()
            .size([width, height])
            .padding(1.5);

    d3.csv("/flare.csv", function (d) {
        d.value = +d.value;
        if (d.value) return d;
    }, function (error, classes) {
        if (error) throw error;

        var root = d3.hierarchy({children: classes})
                .sum(function (d) {
                    return d.value;
                })
                .each(function (d) {
                    if (id = d.data.id) {
                        var id, i = id.lastIndexOf(".");
                        d.id = id;
                        d.package = id.slice(0, i);
                        d.class = id.slice(i + 1);
                    }
                });

        var node = svg.selectAll(".node")
                .data(pack(root).leaves())
                .enter().append("g")
                .attr("class", "node")
                .attr("transform", function (d) {
                    return "translate(" + d.x + "," + d.y + ")";
                });

        node.append("circle")
                .attr("id", function (d) {
                    return d.id;
                })
                .attr("r", function (d) {
                    return d.r;
                })
                .style("fill", function (d) {
                    return color(d.package);
                });

        node.append("clipPath")
                .attr("id", function (d) {
                    return "clip-" + d.id;
                })
                .append("use")
                .attr("xlink:href", function (d) {
                    return "#" + d.id;
                });

        node.append("text")
                .attr("clip-path", function (d) {
                    return "url(#clip-" + d.id + ")";
                })
                .selectAll("tspan")
                .data(function (d) {
                    return d.class.split(/(?=[A-Z][^A-Z])/g);
                })
                .enter().append("tspan")
                .attr("x", 0)
                .attr("y", function (d, i, nodes) {
                    return 13 + (i - nodes.length / 2 - 0.5) * 10;
                })
                .text(function (d) {
                    return d;
                });

        node.append("title")
                .text(function (d) {
                    return d.id + "\n" + format(d.value);
                });
    });
}

/**
 * Generates histogram graphic from randomly generated data
 * @todo plot histogram for grades
 * @return no return value, generated graph is places in svg
 */
function histogram() {
    $("#svg").empty();
    var data = d3.range(100).map(d3.randomBates(10));

    var formatCount = d3.format(",.0f");

    var svg = d3.select("svg"),
            margin = {top: 10, right: 10, bottom: 10, left: 10},
            width = +document.getElementById('dashboard').offsetWidth,
            height = +document.getElementById('dashboard').offsetWidth-100;

    g = svg.append("g").attr("transform", "translate(" + margin.left + "," + margin.top + ")");

    var x = d3.scaleLinear()
            .rangeRound([0, width]);

    var bins = d3.histogram()
            .domain(x.domain())
            .thresholds(x.ticks(20))
            (data);

    var y = d3.scaleLinear()
            .domain([0, d3.max(bins, function (d) {
                return d.length;
            })])
            .range([height, 0]);

    var bar = g.selectAll(".bar")
            .data(bins)
            .enter().append("g")
            .attr("class", "bar")
            .attr("transform", function (d) {
                return "translate(" + x(d.x0) + "," + y(d.length) + ")";
            });

    bar.append("rect")
            .attr("x", 1)
            .attr("width", x(bins[0].x1) - x(bins[0].x0) - 1)
            .attr("height", function (d) {
                return height - y(d.length);
            });

    bar.append("text")
            .attr("dy", ".75em")
            .attr("y", 6)
            .attr("x", (x(bins[0].x1) - x(bins[0].x0)) / 2)
            .attr("text-anchor", "middle")
            .text(function (d) {
                return formatCount(d.length);
            });

    g.append("g")
            .attr("class", "axis axis--x")
            .attr("transform", "translate(0," + height + ")")
            .call(d3.axisBottom(x));
}

/**
 * Generates linear chart graphic
 * @return no return value, generated graph is places in svg
 */
function linear_chart() {
    $("#svg").empty();
    var svg = d3.select("svg"),
            margin = {top: 10, right: 30, bottom: 10, left: 30},
            width = +document.getElementById('dashboard').offsetWidth,
            height = +document.getElementById('dashboard').offsetWidth-100;
            g = svg.append("g").attr("transform", "translate(" + margin.left + "," + margin.top + ")");

    console.log(document.getElementById('dashboard').offsetWidth-100);

    var x0 = d3.scaleLinear()
            .domain([0, 9])
            .range([0, 500]);

    var x1 = d3.scaleLinear()
            .domain([0, 9])
            .range([0, 500]);


    var y = d3.scaleLinear()
            .domain([5, 2])
            .range([10, 500]);

    var line = d3.line()
            .x(function (d) {
                return x0(d.id);
            })
            .y(function (d) {
                return y(d.year_middle);
            });

    d3.csv("fakeData.csv", function (d) {
        d.id = parseInt(d.id);
        d.year_middle = parseFloat(d.year_middle);
        return d;
    }, function (error, data) {
        if (error) throw error;

        x0.domain(d3.extent(data, function (d) {
            return d.id;
        }));
        y.domain(d3.extent(data, function (d) {
            return d.year_middle;
        }));

        // adding x axes
        g.append("g")
                .attr("transform", "translate(0," + height + ")")
                .call(d3.axisBottom(x0))
                .select(".domain")
                .remove();

        //adding y axes
        g.append("g")
                .call(d3.axisLeft(y))
                .append("text")
                .attr("fill", "#000")
                .attr("transform", "rotate(-90)")
                .attr("y", 6)
                .attr("dy", "0.71em")
                .attr("text-anchor", "end")
                .text("среднегодовая оценка");

        console.log(data);
        // adding line
        g.append("path")
                .datum(data)
                .attr("fill", "none")
                .attr("stroke", "steelblue")
                .attr("stroke-linejoin", "round")
                .attr("stroke-linecap", "round")
                .attr("stroke-width", 1.5)
                .attr("d", line);
    });
}

// функция для подключения виджета datetimepicker
$(function () {
    $('#datetimepicker_from').datetimepicker(
            {
                language: 'ru',
                pickTime: false,
                format: 'DD/MM/YYYY'
            }
    );
});

// функция для подключения виджета datetimepicker
$(function () {
    $('#datetimepicker_to').datetimepicker(
            {
                language: 'ru',
                pickTime: false,
                format: 'DD/MM/YYYY'
            }
    );
});