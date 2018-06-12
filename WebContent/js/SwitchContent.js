var switchContent = function (page) {
    $.ajax({
        url: page,
    }).done(function (data) {
        $("#content").html(data);
    });
};

switchContent('/Mostar/templates/content.xhtml');