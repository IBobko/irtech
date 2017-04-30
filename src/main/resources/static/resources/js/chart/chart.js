// вызывется при открытии страницы для отрисовки начального состояния графиков
window.onload = function() {
    switch_chart('#learn')
};

/**
 * this function switches between graphs
 * @type the type of graph to be loaded
 */
    function switch_chart(type){
    // prevent page reload
    event.preventDefault();
    if (type=='#prof') {
        $('#prof').addClass('active');
        $('#corr').removeClass('active');
        $('#learn').removeClass('active');
        $('#header').empty();
        $('#header').append("Проф ориентация");
        bubble_chart("Тестовый график");
    }
    else if(type=='#corr') {
        $('#corr').addClass('active');
        $('#prof').removeClass('active');
        $('#learn').removeClass('active');
        $('#header').empty();
        $('#header').append("Корреляции");
        bar_chart('Средняя оценка за год',0.3, 'Средняя оценка за четверть',0.9, 'Зависимость оценок от полноты семьи');
    }
    else if (type=='#learn'){
        $('#corr').removeClass('active');
        $('#prof').removeClass('active');
        $('#learn').addClass('active');
        $('#header').empty();
        $('#header').append("Обучение");
        histogram("Распределения оценок");
    }
}

/**
 * @warning! This is a test chart with no information logically correlating with our system
 * Generates bubble chart graphic from flare.csv file (some fake data)
 * @graph_name name of the chart which is sotrred into svg
 * @return no return value, generated graph is places in svg
 */
function bubble_chart(graph_name) {

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
 * @graph_name name of the chart which is sotrred into svg
 * @return no return value, generated graph is places in svg
 */
function histogram(graph_name) {
    $("#svg").empty();
    var data = d3.range(100).map(d3.randomBates(5));

    var formatCount = d3.format(",.0f");

    var svg = d3.select("svg"),
        margin = {top: 30, right: 10, bottom: 10, left: 10},
        width = +document.getElementById('dashboard').offsetWidth,
        height = +document.getElementById('dashboard').offsetWidth-100;

    g = svg.append("g").attr("transform", "translate(" + margin.left + "," + margin.top + ")");

    var x = d3.scaleLinear()
        .rangeRound([0, width]);

    var bins = d3.histogram()
        .domain(x.domain())
        .thresholds(x.ticks(20))
        (data);

    // scale creation
    var y = d3.scaleLinear()
        .domain([0, d3.max(bins, function (d) {
            return d.length;
        })])
        .range([height, 0]);

    // adding classes for rectangles
    var bar = g.selectAll(".bar")
        .data(bins)
        .enter().append("g")
        .attr("class", "bar")
        .attr("transform", function (d) {
            return "translate(" + x(d.x0) + "," + y(d.length) + ")";
        });

    // adding histogram bars
    bar.append("rect")
        .attr("x", 1)
        .attr("width", x(bins[0].x1) - x(bins[0].x0) - 1)
        .attr("height", function (d) {
            return height - y(d.length);
        });

    // adding y axis
    bar.append("text")
        .attr("dy", ".75em")
        .attr("y", 6)
        .attr("x", (x(bins[0].x1) - x(bins[0].x0)) / 2)
        .attr("text-anchor", "middle")
        .text(function (d) {
            return formatCount(d.length);
        });

    // adding x axis
    g.append("g")
        .attr("class", "axis axis--x")
        .attr("transform", "translate(0," + height + ")")
        .call(d3.axisBottom(x));

    // adding text on the top of the chart
    svg.append("text")
        .attr("x", (width / 2))
        .attr("y", 15)
        .attr("text-anchor", "middle")
        .style("font-size", "16px")
        .text(graph_name);
}

/**
 * Plots bar graph for two attributes
 * @attribute_first name of the first attribute for comparison
 * @correlation_first correlation index for the first attribute
 * @attribute_second name of the first attribute for comparison
 * @correlation_second correlation index for the first attribute
 * @graph_name name which will be represented on the top of the chart
 * @return no return value, generated graph is plot into svg
 */
function bar_chart(attribute_first, correlation_first, attribute_second, correlation_second, graph_name) {
    // cleanin svg field
    $("#svg").empty();

    // setting svg boundaries
    var svg = d3.select("svg"),
        margin = {top: 10, right: 10, bottom: 10, left: 10},
        width = +document.getElementById('dashboard').offsetWidth-100,
        height = +document.getElementById('dashboard').offsetWidth-100;

    g = svg.append("g").attr("transform", "translate(" + margin.left + "," + margin.top + ")");

// creating scale for x axis - scale with oridnal values
    var x = d3.scaleOrdinal()
        .domain(["", attribute_first, attribute_second])
        .range([0, width/3,(width/3)*2, width]);

    // creating scale for y axis - scake with linear values from 0 to 1
    var y = d3.scaleLinear()
        .domain([0, 1])
        .range([height, 0]);

    // creating rectangle for first attribute
    g.append("rect")
        .attr("x", 30)
        .attr("y", height-correlation_first*height)
        .attr("fill", "blue")
        .attr("width", width/3)
        .attr("height", correlation_first*height);

    // creating rectangle for secind attribute
    g.append("rect")
        .attr("x", width - width/3-30)
        .attr("y", height - correlation_second*height)
        .attr("fill", "red")
        .attr("width", width/3)
        .attr("height", correlation_second*height);

    // adding x axis to svg graph
    g.append("g")
        .attr("class", "axis axis--x")
        .attr("transform", "translate(0," + height + ")")
        .call(d3.axisBottom(x));

    // adding y axis to svg graph
    g.append("g")
        .attr("class", "axis axis--y")
        .attr("transform", "translate(" + width + ",0)")
        .call(d3.axisRight(y));

    // adding text on the top of the chart
    svg.append("text")
        .attr("x", (width / 2))
        .attr("y", 15)
        .attr("text-anchor", "middle")
        .style("font-size", "16px")
        .text(graph_name);
}

/**
 * Generates linear chart graphic
 * @depricated
 * @return no return value, generated graph is places in svg
 */
function linear_chart() {
    $("#svg").empty();
    var svg = d3.select("svg"),
        margin = {top: 10, right: 30, bottom: 10, left: 30},
        width = +document.getElementById('dashboard').offsetWidth,
        height = +document.getElementById('dashboard').offsetWidth-100;
    g = svg.append("g").attr("transform", "translate(" + margin.left + "," + margin.top + ")");

    var x0 = d3.scaleLinear()
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