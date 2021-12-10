<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>IOCL Pump Locator</title>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all">
        <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="keywords" content="Location Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
              Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
        <link href='https://fonts.googleapis.com/css?family=PT+Sans:400,700' rel='stylesheet' type='text/css'>
        <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,700,800,600,300' rel='stylesheet' type='text/css'>
        <script src="js/jquery.min.js"></script>
        <script src="https://maps.googleapis.com/maps/api/js?libraries=places&key=AIzaSyCDKNXzPKhm8UWNV_o8MOXSAiZCpc4Hwrg"></script>
        <!--<script src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false&libraries=places"></script>-->
        <script src="js/jquery.easydropdown.js"></script>
        <!-- Mega Menu -->
        <link href="css/megamenu.css" rel="stylesheet" type="text/css" media="all" />
        <script type="text/javascript" src="js/megamenu.js"></script>
        <link href="css/jquery.alerts.css" rel="stylesheet" type="text/css" media="all" />

        <style>
            html, body  {
                height: 100%;
                margin: 0px;
                padding: 2px;
            }

            #map-canvas {
                height: 700px;
                margin: 0px;
                padding: 2px;
                overflow: auto;
                overflow-y: scroll;
            }
            .wrapword{
                white-space: -moz-pre-wrap !important;  /* Mozilla, since 1999 */
                white-space: -webkit-pre-wrap; /*Chrome & Safari */ 
                white-space: -pre-wrap;      /* Opera 4-6 */
                white-space: -o-pre-wrap;    /* Opera 7 */
                white-space: pre-wrap;       /* css-3 */
                word-wrap: break-word;       /* Internet Explorer 5.5+ */
                word-break: break-all;
                white-space: normal;
            }
            #bestView{
                margin-top:1.5em;
                color: white;
                text-align: center;
            }
        </style>
        <script>
            var isClick = 1;
            var curr_lat, curr_lang;
            var locations = [];
            navigator.geolocation.getCurrentPosition(function (position) {
                var pos = {
                    lat: position.coords.latitude,
                    lng: position.coords.longitude
                };

                curr_lat = pos.lat;
                curr_lang = pos.lng;

            }, function () {
            });

            $(document).ready(function () {
                $("#addWayponts").click(function () {
                    $('#waypoints').append('<option value="5">' + $("#waypoint").val() + '</option>');
                    $('#waypoint').val("");
                });
                $("#clearList").click(function () {
                    $("#waypoints option").remove();

                });
                $('#locateoutlet, #listoutlet').click(function () {
                    if (this.id == 'locateoutlet') {
                        isClick = 1;
                    } else if (this.id == 'listoutlet') {
                        isClick = 2;
                    }
                });
                $("body").on("contextmenu", function (e) {
                    return false;
                });

                //Disable part of page
                $("#id").on("contextmenu", function (e) {
                    return false;
                });
                $('body').bind('cut copy paste', function (e) {
                    e.preventDefault();
                });

                //Disable mouse right click
                $("body").on("contextmenu", function (e) {
                    return false;
                });
            });

            $(document).bind('selectstart dragstart', function (e) {
                e.preventDefault();
                return false;
            });
            var map;
            var currlat = 19.0544, currlong = 72.8406;
            var directionsDisplay;
            var directionsService;
            var stepDisplay;
            var markerArray = [];
            var lat;
            var lon;

            function initialize()
            {
                var newDelhi = new google.maps.LatLng(currlat, currlong);
                var mapOptions = {zoom: 6, center: newDelhi};
                map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);
                directionsDisplay = new google.maps.DirectionsRenderer({polylineOptions: {strokeColor: "RED"}});

                directionsDisplay.setMap(map);
                directionsService = new google.maps.DirectionsService();  // Create a map and center it on New Delhi.  
                var address = (document.getElementById('source'));
                var autocomplete = new google.maps.places.Autocomplete(address);
                autocomplete.setTypes(['geocode']);
                google.maps.event.addListener(autocomplete, 'place_changed', function () {
                    var place = autocomplete.getPlace();
                    if (!place.geometry) {
                        return;
                    }

                    var address = '';
                    if (place.address_components) {
                        address = [
                            (place.address_components[0] && place.address_components[0].short_name || ''),
                            (place.address_components[1] && place.address_components[1].short_name || ''),
                            (place.address_components[2] && place.address_components[2].short_name || '')
                        ].join(' ');
                    }
                });

                var address2 = (document.getElementById('destination'));
                var autocomplete = new google.maps.places.Autocomplete(address2);
                autocomplete.setTypes(['geocode']);
                google.maps.event.addListener(autocomplete, 'place_changed', function () {
                    var place = autocomplete.getPlace();
                    if (!place.geometry) {
                        return;
                    }

                    var address2 = '';
                    if (place.address_components) {
                        address2 = [
                            (place.address_components[0] && place.address_components[0].short_name || ''),
                            (place.address_components[1] && place.address_components[1].short_name || ''),
                            (place.address_components[2] && place.address_components[2].short_name || '')
                        ].join(' ');
                    }
                });

                var address3 = (document.getElementById('waypoint'));
                var autocomplete = new google.maps.places.Autocomplete(address3);
                autocomplete.setTypes(['geocode']);
                google.maps.event.addListener(autocomplete, 'place_changed', function () {
                    var place = autocomplete.getPlace();
                    if (!place.geometry) {
                        return;
                    }

                    var address3 = '';
                    if (place.address_components) {
                        address3 = [
                            (place.address_components[0] && place.address_components[0].short_name || ''),
                            (place.address_components[1] && place.address_components[1].short_name || ''),
                            (place.address_components[2] && place.address_components[2].short_name || '')
                        ].join(' ');
                    }
                });

//                var rendererOptions = {map: map, polylineOptions: { strokeColor: "GREEN" } }
//                directionsDisplay = new google.maps.DirectionsRenderer(rendererOptions)  // Instantiate an info window to hold step text.  
                stepDisplay = new google.maps.InfoWindow();

            }

            function calcRoute() {

                for (var i = 0; i < markerArray.length; i++) {
                    markerArray[i].setMap(null);
                }
                markerArray = [];
                var start = $("#source").val();
                var end = $("#destination").val();
                var waypts = [];
                $("#waypoints > option").each(function () {
                    waypts.push({
                        location: $(this).text(),
                        stopover: true});
                });

                var request = {
                    origin: start,
                    destination: end,
                    travelMode: google.maps.TravelMode.DRIVING
                    , waypoints: waypts
                };
                directionsService.route(request, function (response, status) {
                    if (status === google.maps.DirectionsStatus.OK) {
                        var warnings = document.getElementById('warnings_panel');
                        warnings.innerHTML = '<b>' + response.routes[0].warnings + '</b>';

                        getCoordinates(response);
                        directionsDisplay.setDirections(response);
                    }
                });
            }
            var latArray = [];
            var lngArray = [];
            function getCoordinates(result) {

                var currentRouteArray = result.routes[0];  //Returns a complex object containing the results of the current route
                var currentRoute = currentRouteArray.overview_path; //Returns a simplified version of all the coordinates on the path
                for (var x = 0; x < currentRoute.length; x++) {
                    latArray[x] = currentRoute[x].lat(); //Returns the latitude of routes from Source to destination
                    lngArray[x] = currentRoute[x].lng(); //Returns the longitude of routes from Source to destination
                }
                if (isClick === 1) {
                    currlat = latArray[0];
                    currlong = lngArray[0];
                    // alert("latitude Array"+latArray.toString()+"Longitude array"+ lngArray.toString())
                    initialize();
                    showPosition(latArray.toString(), lngArray.toString());

                } else if (isClick === 2) {
                    isClick = 3;
                    generateTable();
                }
            }
            function showPosition(currlat, currlong) {
                $.ajax({
                    url: "./MapLocations",
                    type: "POST",
                    data: {latitude: currlat, longitude: currlong, lat: curr_lat, long: curr_lang},
                    async: false,
                    success: function (data) {
                        if (data != "") {
                            locations = data.toString().split("|");

                        }
                    }
                });

                var promowindow = new google.maps.InfoWindow();
                var infowindow = new google.maps.InfoWindow();
                var marker, i, promomarker;
                for (i = 0; i < locations.length; i++) {
                    marker = new google.maps.Marker({
                        position: new google.maps.LatLng(locations[i].split(",")[1], locations[i].split(",")[2]),
                        map: map,
                        title: locations[i].split(",")[0],
                        icon: locations[i].split(",")[39] === 'Y' ? './images/covid-special.png' : './images/petrol.png'});


                    marker.setMap(map);

//                    }
//                    if (locations[i].split(",")[39] != "N") {
////                        alert("Active Value " + locations[i].split(",")[39] + " Promo Name " + locations[i].split(",")[37] + " " + locations[i].split(",")[38]);
//                        promomarker = new google.maps.Marker({
//                            position: new google.maps.LatLng(locations[i].split(",")[1], locations[i].split(",")[2]),
//                            map: map,
//                            title: locations[i].split(",")[0],
//                            icon: './images/gift.png'
//                        });
//                        promomarker.setMap(map);
//                        google.maps.event.addListener(promomarker, 'click', (function (promomarker, i) {
//                            return function () {
//                                $.ajax({
//                                    url: './promodetails',
//                                    type: 'post',
//                                    data: {promo_code: locations[i].split(",")[38], ro_code: locations[i].split(",")[36]},
//                                    success: function (data) {
//
//                                        $("#promodata").html(data);
//                                    }
//
//                                });
//                                promowindow.setContent("<div><img src='./images/company.png' align='right' width ='75' height='60'/><h4 style='color:blue'>" + locations[i].split(",")[0] + "</h4><div id='promodata'></div></div>");
//
//                                promowindow.open(map, promomarker);
//                            }
//                        })(promomarker, i));
//                    }

                    google.maps.event.addListener(marker, 'click', (function (marker, i) {
                        return function () {
                            var sdlatitude = locations[i].split(",")[1];
                            var sdlongitude = locations[i].split(",")[2];
                            var locDetails = locations[i].split(",");
                            var source = $("#source").val();
                            var service = new google.maps.DistanceMatrixService();
                            var dist = 0;
                            service.getDistanceMatrix({
                                origins: [source],
                                destinations: [new google.maps.LatLng(sdlatitude, sdlongitude)],
                                travelMode: google.maps.TravelMode.DRIVING,
                                unitSystem: google.maps.UnitSystem.METRIC,
                                avoidHighways: false,
                                avoidTolls: false
                            }, function (response, status) {

                                if (status == google.maps.DistanceMatrixStatus.OK && response.rows[0].elements[0].status != "ZERO_RESULTS") {
                                    var distancecalculated = response.rows[0].elements[0].distance.text;
                                    var duration = response.rows[0].elements[0].duration.text;
                                    var dvDistance = document.getElementById("tempDiv");
                                    dvDistance.innerHTML = "";
                                    dvDistance.innerHTML += "Distance from Source " + $("#source").val() + " is " + distancecalculated + " and  Duration via road is " + duration;
                                } else {
                                    alert("Unable to find the distance via road.");
                                }
                            });

                            var str = "<tr><td colspan='2'><b>Product & Price</b></td></tr><table border='1' width='100%'>" +
                                    "<tr>" + ((locDetails[25] != ' ' && locDetails[25] != '0' && locDetails[25] != 'Not Available') ?
                                            "<td align='center'><img src='./images/petrol.png' width='75' height='42'/>  Petrol</td>" : "") +
                                    ((locDetails[26] != ' ' && locDetails[26] != '0' && locDetails[26] != 'Not Available') ?
                                            "<td align='center'> <img src='./images/diesel.png' width='110' height='28'/></td>" : "") +
                                    ((locDetails[27] != ' ' && locDetails[27] != '0' && locDetails[27] != 'Not Available') ?
                                            "<td align='center'><img src='./images/xtrapremium.png' width='110' height='36'/></td>" :
                                            "") + ((locDetails[28] != ' ' && locDetails[28] != '0' && locDetails[28] != 'Not Available') ?
                                    "<td align='center'><img src='./images/xtramile.png' width='80' height='80'/></td>" : "") +
                                    ((locDetails[42] != ' ' && locDetails[42] != '0' && locDetails[42] != 'Not Available') ?
                                            "<td align='center'><img src='./images/xp100.jpeg' width='110' height='36'/></td>" :
                                            "") +
                                    ((locDetails[43] != ' ' && locDetails[43] != '0' && locDetails[43] != 'Not Available') ?
                                            "<td align='center'><img src='./images/xp95.jpeg' width='110' height='36'/></td>" :
                                            "") +
                                    ((locDetails[44] != ' ' && locDetails[44] != '0' && locDetails[44] != 'Not Available') ?
                                            "<td align='center'><img src='./images/xg.jpeg' width='110' height='36'/></td>" :
                                            "") +
                                    ((locDetails[45] != ' ' && locDetails[45] != '0' && locDetails[45] != 'Not Available') ?
                                            "<td align='center'><img src='./images/e100.jpeg' alt='E100' width='110' height='36'/></td>" :
                                            "") +
                                    "</tr>" +
                                    "<tr>" + ((locDetails[25] != ' ' && locDetails[25] != '0' && locDetails[25] != 'Not Available') ?
                                            "<td align='center'>Rs. " + locDetails[25].toString() + "/Litre</td>" : "")
                                    + ((locDetails[26] != ' ' && locDetails[26] != '0' && locDetails[26] != 'Not Available') ?
                                            "<td align='center'>Rs. " + locDetails[26].toString() + "/Litre</td>" : "") +
                                    ((locDetails[27] != ' ' && locDetails[27] != '0' && locDetails[27] != 'Not Available') ?
                                            "<td align='center'>Rs. " + locDetails[27].toString() + "/Litre</td>" : "")
                                    + ((locDetails[28] != ' ' && locDetails[28] != '0' && locDetails[28] != 'Not Available') ?
                                            "<td align='center'>Rs. " + locDetails[28].toString() + "/Litre</td>" : "") +
                                    ((locDetails[42] != ' ' && locDetails[42] != '0' && locDetails[42] != 'Not Available') ?
                                            "<td align='center'>Rs. " + locDetails[42].toString() + "/Litre</td>"
                                            : "") +
                                    ((locDetails[43] != ' ' && locDetails[43] != '0' && locDetails[43] != 'Not Available') ?
                                            "<td align='center'>Rs. " + locDetails[43].toString() + "/Litre</td>"
                                            : "")+
                                    ((locDetails[44] != ' ' && locDetails[44] != '0' && locDetails[44] != 'Not Available') ?
                                            "<td align='center'>Rs. " + locDetails[44].toString() + "/Litre</td>"
                                            : "")+
                                    ((locDetails[45] != ' ' && locDetails[45] != '0' && locDetails[45] != 'Not Available') ?
                                            "<td align='center'>Rs. " + locDetails[45].toString() + "/Litre</td>"
                                            : "")
                                                    + "</tr></table></tr>" +
                                    "</table>";
                            infowindow.setContent("<div><table> " +
                                    "<tr><td><img src='./images/servo.png' width ='60%' height='80%'/></td><td align='right'><img src='./images/company.png' width ='75' height='60'/> </td></tr>" +
                                    "<tr><td class='wrapword' colspan='2'><b><font color='blue'>" + locDetails[0] + " (" + locDetails[38] + ")</font></b></td></tr>" +
                                    "<tr><td class='wrapword' colspan='2'><b><font color='green'><div id='tempDiv'></div></font></b></td></tr>" +
                                    "<tr><td class='wrapword' colspan='2'><b>" + locDetails[3] + "</b></td></tr>" +
                                    "<tr><td  colspan='2'><b>" + locDetails[30] + "</b></td></tr>" +
                                    "<tr><td colspan='2'> <font color='red'><b>" + locDetails[29] + "</b></font></td></tr>" +
                                    "<tr><td colspan='2' style='border-bottom: 1px solid black;'></td></tr>" +
                                    ((locDetails[15].toUpperCase().trim() != ' ' && locDetails[15].toUpperCase().trim() != '-') ?
                                            "<tr><td>Working Hours</td><td>" + locDetails[15].split("-")[0] + " HRs-" + locDetails[15].split("-")[1] + " HRs" + "</td></tr>"
                                            : "") +
                                    "<tr style='border-bottom:1px solid black'></tr>" +
                                    "<tr><td colspan='2'><table width='100%'><tr>" +
                                    ((locDetails[19].toUpperCase() == "YES") ?
                                            "<td align='center'><img src='./images/xtrapower.png' width='60' height='42'/></td>"
                                            : "") +
                                    ((locDetails[20].toUpperCase() == "YES") ?
                                            "<td align='center'><img src='./images/xtrarewards.png' width='60' height='42'/></td>"
                                            : "") +
                                    ((locDetails[10] != null && locDetails[10].toUpperCase() != '' && locDetails[10].toUpperCase() != ' ') ?
                                            "<td><font color='green'>Network Outlet</font></td>"
                                            : "") +
                                    ((locDetails[19].toUpperCase() == 'YES') ?
                                            "<td><img src='./images/automated.png' width='60' height='42'/><b><font color='orange'> Automated</font></b></td>"
                                            : "") +
                                    "</tr></table></td></tr>" +
                                    "<tr><td colspan='2' ><b>Services</b></td></tr>" +
                                    "<tr><td colspan='2' ></td></tr>" +
                                    ((locDetails[39].toUpperCase() == 'Y') ?
                                            "<tr><td>COVID-19-FOOD & RELIEF -- " + locDetails[40] + " [" + locDetails[41] + "]</td><td align='center'><img src='./images/covid.png' width='100' height='100'/></tr>"
                                            : "") +
                                    ((locDetails[4].toUpperCase() == 'YES') ?
                                            "<tr><td>WashRoom</td><td align='center'><img src='./images/logo4.png' width='42' height='42'/></tr>"
                                            : "") +
                                    ((locDetails[5].toUpperCase() == 'YES') ?
                                            "<tr><td>Credit Card Accepted</td><td align='center'><img src='./images/logo8.png' width='42' height='42'/></td></tr>"
                                            : "") +
                                    ((locDetails[22].toUpperCase() == 'YES') ?
                                            "<tr><td>Separate Rest Rooms</td><td align='center'><img src='./images/logo5.png' width='42' height='42'/></td></tr>"
                                            : "") +
                                    ((locDetails[8].toUpperCase() == 'YES') ?
                                            "<tr><td>Parking</td align='center'><td align='center'><img src='./images/logo2.png' width='42' height='42'/></td></tr>"
                                            : "") +
                                    ((locDetails[9].toUpperCase() == 'YES') ?
                                            "<tr><td>ATM</td><td align='center'><img src='./images/logo1.png' width='42' height='42'/></td></tr>"
                                            : "") +
                                    ((locDetails[10].toUpperCase() == 'YES' || (locDetails[7].toUpperCase() == 'YES')) ?
                                            "<tr><td>Food Joint</td><td align='center'><img src='./images/logo3.png' width='42' height='42'/></td></tr>"
                                            : "") +
                                    ((locDetails[12].toUpperCase() == 'YES') ?
                                            "<tr><td>Service Station</td><td align='center'><img src='./images/logo9.png' width='42' height='42'/></td></tr>"
                                            : "") +
                                    ((locDetails[13].toUpperCase() == 'YES') ?
                                            "<tr><td>Convenio Store</td><td align='center'><img src='./images/cstore.png' width='42' height='42'/></td></tr>"
                                            : "") +
                                    ((locDetails[14].toUpperCase() == 'YES') ?
                                            "<tr><td>Pollution Control</td><td align='center'><img src='./images/puc.png' width='42' height='42'/></td></tr>"
                                            : "") +
                                    ((locDetails[23].toUpperCase() == "YES") ?
                                            "<tr><td>Drinking Water</td><td align='center'><img src='./images/logo7.png' width='42' height='42'/></td></tr>"
                                            : "") +
                                    ((locDetails[24].toUpperCase() == 'YES') ?
                                            "<tr><td>Free Air</td><td align='center'><img src='./images/logo6.png' id='img1' width='42' height='42'/></td></tr>"
                                            : "") +
                                    "<tr><td>First Aid Box</td><td align='center'><img src='./images/logo10.png' width='42' height='42'/></td></tr>" +
                                    "<tr><td colspan='2' style='border-bottom: 1px solid black;'></td></tr>" +
                                    "<tr>" + str + "</tr></div>"
                                    );

                            infowindow.open(map, marker);

                        }
                    })(marker, i));

                }

            }
            function generateTable() {
                calcRoute();
                $("#map-canvas").html("");
//                alert(latArray.toString() + "----" + lngArray.toString() + "---" + curr_lat + "----" + curr_lang);
                $.ajax({
                    url: "./MapLocations",
                    type: "POST",
                    data: {latitude: latArray.toString(), longitude: lngArray.toString(), lat: curr_lat, long: curr_lang},
                    async: false,
                    success: function (data) {
                        if (data != "") {
                            locations = data.toString().split("|");
                            var str = "";
                            str += "<tr><th>Sr.</th><th>RO Code</th><th>Petrol Pump Name</th><th>COVID-19 Food & Relief Contact</th><th>Address</th><th>Dealer/Partner/Operator/Contact Person Name</th><th>Contact No</th><th>Petrol Price</th><th>Diesel Price</th><th>XTRAPREMIUM Price</th><th>XTRAMILE Price</th><th>XP100 Price</th><th>XP95 Price</th><th>XG Price</th><th>E100 Price</th><th>District</th><th>State</th>" +
                                    "<th>State Office</th><th>Divisional Office</th><th>Sales Area</th><th>Sales Officer Contact No</th><th>Distance from Source</th></tr>"
                            var columnCount = locations[0].split(",").length;
                            for (var i = 0; i < locations.length - 1; i++) {
                                var a = "", b = "", c = "", d = "", e = "", f = "", g = "", h = "", k = "", m = "", ms = "",
                                        hsd = "", xp = "", xm = "", dist = "", rocode = "", xp100 = "", xp95 = "", xg = "", e100 = "";
                                var covideliefContact = "";
                                str += "<tr><td>" + (i + 1) + "</td>";
                                for (var j = 0; j < columnCount; j++) {
                                    if (j === 40) {
                                        if (locations[i].split(",")[j - 1] === 'Y') {
                                            covideliefContact = "<td>" + " " + locations[i].split(",")[j] + " [" + locations[i].split(",")[j + 1] + "]</td>";
                                        } else {
                                            covideliefContact = "<td>N/A</td>";
                                        }
                                    }
                                    if (j == 34) {
                                        a = "<td>" + " " + locations[i].split(",")[j] + " " + "</td>";
                                    }
                                    if (j == 36) {
                                        m = "<td>" + " " + locations[i].split(",")[j] + " " + "</td>";
                                    }
                                    if (j == 30) {
                                        b = "<td>" + " " + locations[i].split(",")[j] + " " + "</td>";
                                    }
                                    if (j == 35) {
                                        c = "<td>" + " " + locations[i].split(",")[j] + " " + "</td>";
                                    }
                                    if (j == 37) {
                                        var val = locations[i].split(",")[j];
                                        if (val < 1) {
                                            val = val * 1000 + "M";
                                        } else {
                                            val = val + "Km";
                                        }
                                        dist = "<td>" + " " + val + " " + "</td>";
                                    }

                                    if (j == 25) {
                                        ms = "<td>" + " " + locations[i].split(",")[j] + " " + "</td>";
                                    }
                                    if (j == 26) {
                                        hsd = "<td>" + " " + locations[i].split(",")[j] + " " + "</td>";
                                    }
                                    if (j == 27) {
                                        xp = "<td>" + " " + locations[i].split(",")[j] + " " + "</td>";
                                    }
                                    if (j == 28) {
                                        xm = "<td>" + " " + locations[i].split(",")[j] + " " + "</td>";
                                    }


                                    if (j == 31) {
                                        d = "<td>" + " " + locations[i].split(",")[j] + " " + "</td>";
                                    }
                                    if (j == 32) {
                                        e = "<td>" + " " + locations[i].split(",")[j] + " " + "</td>";
                                    }
                                    if (j == 0) {
                                        f = "<td>" + " " + locations[i].split(",")[j] + " " + "</td>";
                                    }
                                    if (j == 3) {
                                        g = "<td>" + " " + locations[i].split(",")[j] + " " + "</td>";
                                    }
                                    if (j == 33) {
                                        h = "<td>" + " " + locations[i].split(",")[j] + " " + "</td>";
                                    }
                                    if (j == 29) {
                                        k = "<td>" + " " + locations[i].split(",")[j] + " " + "</td>";
                                    }
                                    if (j == 38) {
                                        rocode = "<td>" + " " + locations[i].split(",")[j] + " " + "</td>";
                                    }
                                    if (j == 42) {
                                        xp100 = "<td>" + " " + locations[i].split(",")[j] + " " + "</td>";
                                    }
                                    if (j == 43) {
                                        xp95 = "<td>" + " " + locations[i].split(",")[j] + " " + "</td>";
                                    }
                                    if (j == 44) {
                                        xg = "<td>" + " " + locations[i].split(",")[j] + " " + "</td>";
                                    }
                                    if (j == 45) {
                                        e100 = "<td>" + " " + locations[i].split(",")[j] + " " + "</td>";
                                    }

                                }
                                str += rocode + f + covideliefContact + g + b + m + ms + hsd + xp + xm + xp100 + xp95 + xg + e100 + a + c + d + e + h + k + dist + "</tr>";
                            }

                            $("#map-canvas").html("<table class='responstable'>" + str + "</table>");
                            $("#map-canvas").css("overflow", "inherit");
                            $("#map-canvas").css("height", "900px");
                            $("#map-canvas").css("width", "100%");
//                            $("#map-canvas").css("overflow-y", "scroll");
//                            $("#map-canvas").css("overflow-X", "scroll");

                            locations = [];
                        }
                    }
                });


            }

            google.maps.event.addDomListener(window, 'load', initialize);
        </script> 
        <style>
            .btnAdjust{
                margin-left: 30em;
                margin-top:-5.5em;
            }
        </style>
        <!-- Mega Menu -->
    </head>
    <body>
        <!-- banner -->
        <div class="header">
            <a href="https://www.iocl.com" target="blank"><img width="100%" height="200px" src="images/banner.png"></a>        </div>
        <div  class="header-bottom">
            <div class="container">
                <div class="top-nav">
                    <span class="menu"></span>
                    <ul class="navig megamenu skyblue">
                        <li><a href="location.jsp" class="scroll"><span></span>Locate Indian Oil Petrol pump</a></li>
                        <li ><a href="routeROs.jsp" class="scroll"> <span class="service"> </span>Route – Source to Destination</a></li>
                        <li ><a href="networkedRO.jsp" class="scroll"> <span class="service"> </span>Petrol pumps on National Highway</a></li>
                        <li ><a href="stateWiseRO.jsp" class="scroll"> <span class="service"> </span>Petrol pumps in State</a></li>
                        <li ><a href="districtWiseRO.jsp" class="scroll"> <span class="service"> </span>Petrol pumps in District</a></li>
                        <div class="clearfix"></div>
                    </ul>
                    <script>

                        $("span.menu").click(function () {
                            $(".top-nav ul").slideToggle(300, function () {
                            });
                        });
                    </script>
                </div><br>

            </div>
            <div  id="bestView"><b>Best View  IE10 or above, Google Chrome, Mozilla FireFox</b></div>
        </div>
        <!-- 404 -->
        <div class="location">
            <div class="container" style="width:100%;">
                <table style="width:100%">
                    <tr>
                        <td>
                            <div class="locat-left" style="width:65%;">       

                                <table style="width: 100%"><tr>
                                        <td><label ><b>Source : </b></label></td>
                                        <td><input type='text' style='border-radius: 5px; height: 30px;' size="25" id="source"/></td>
                                        <td><label><b>Destination : </b></label></td>
                                        <td><input type='text' style='border-radius: 5px; height: 30px;' size="25" id="destination"/></td>
                                    </tr><tr>
                                        <td><input type='button' style='border: 3px solid #6D7B80;border-radius: 5px;  width: 15em;  height: 2.5em; ' id="locateoutlet" value='Locate Petrol Pump on Map' onclick="calcRoute()"/></td>
                                        <td></td><td></td><td><input type='button' style='border: 3px solid #6D7B80;border-radius: 5px;   width: 12em;  height: 2.5em;' id="listoutlet" value='List of Petrol Pumps' onClick="generateTable();"/></td>
                                    </tr><tr>
                                        <td><label ><b>via Location(s): </b></label></td>
                                        <td colspan="2"><input type="text" style='border-radius: 5px; height: 30px;' size="25" id="waypoint"/></td>
                                        <td><input type="button" style='border: 3px solid #6D7B80;border-radius: 5px;  width: 12em;  height: 2.5em;' id="addWayponts" value="Add via Location(s)"/></td>

                                    </tr>
                                    <tr>
                                        <td><select style='width: 12em; height: 2.5em;' id="waypoints" multiple></select></td>
                                        <td><input style=' border: 3px solid #6D7B80;border-radius: 5px;  width: 12em;  height: 2.5em; ' type="button" id="clearList" value="Clear Location(s)"/></td>
                                        <td></td><td></td>
                                    </tr></table>
                            </div> 
                        </td>
                        <td>
                            <div style="float: right;margin-top: 1%;">
                                <img src="images/banner3.png"/>
                            </div>
                        </td>
                    </tr>
<!--                    <tr>
                        <td colspan="2" style="color:red">We are providing food and other relief facilities at Petrol pumps marked with "GREEN Symbol" amid the COVID-19 crisis.  </td>
                    </tr>-->
                </table>


            </div>
        </div>

        <div id="map-canvas" style="overflow-y: scroll;"></div>
        <div id="warnings_panel" style="width:100%;height:10%;text-align:center"></div>  
        <div id="processing">
            <div class="overlay">
                <center><div id="loader"></div></center>
            </div>
        </div>
        <br/><br/>
        <!-- 404 -->
        <div class="footer">

            <div class="container">

                <div class="clearfix"></div>
                <div class="footer-bottom">

                    <p style="text-align: center">Copyrights © 2015 Location All rights reserved &nbsp; Indian Oil Corporation Ltd</p>
                </div>
            </div>
        </div>
    </body>
</html>