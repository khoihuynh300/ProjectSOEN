var myCarousel = $("#myCarousel");
var myNav = myCarousel.next();

myNav.find("li > a").click(function () {
  var newIndex = $(this).parent().index();
  myCarousel.carousel(newIndex);
});

myCarousel.on("slid.bs.carousel", function () {
  var newIndex = $(this).find(".carousel-inner>.active").index();
  var newLI = myNav.children().eq(newIndex);
  if (!newLI.hasClass("active")) {
    myNav.find("li.active").removeClass("active");
    newLI.addClass("active");
  }
});

$("#myCarousel").carousel({
  wrap: true,
  keyboard: true,
  interval: false,
});
