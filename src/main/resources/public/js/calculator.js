var calculator = (function () {

    return {
        putDataOnTable: function () {
            $.get("/calculator/result", function (data) {
                var dataJson = JSON.parse(data.message);
                //var dataJson = JSON.parse(data);
                $("#tableResult").find("#tableResultTbody").append(
                    "<tr><td>" + dataJson.mean + "</td><td>" + dataJson.standardDeviation + "</td></tr>"
                );
            });
        }
    };

})();