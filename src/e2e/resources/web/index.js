// Where you want to render the map.
var element = document.getElementById('osm-map');
const streetname = document.getElementById('streetname')
const start = document.getElementById('start')
const end = document.getElementById('end')
const startCordLat = document.getElementById('startCordLat')
const startCordLon= document.getElementById('startCordLon')
const endCordLat = document.getElementById('endCordLat')
const endCordLon= document.getElementById('endCordLon')

const polylines = [];
const markers = [];

// Height has to be set. You can do this in CSS too.
element.style = 'height:100vh;';

// Create Leaflet map on map element.
var index = L.map(element);

// Add OSM tile layer to the Leaflet map.
L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png', {
    attribution: '&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors'
}).addTo(index);

// Target's GPS coordinates.
var target = L.latLng(46.038646, 14.505751);

// Set map's center to target with zoom 14.
index.setView(target, 16);

// Place line on the map
fetch("http://localhost:8080/lines").then(res => {
    res.json().then(lines => {
        for (line of lines) {
            L.polyline(line, {weight: 1, color: 'blue'}).addTo(index)
        }
    })
})

function clearStart() {
    start.innerHTML = ''
}

function clearEnd() {
    end.innerHTML = ''
}

function clearMap(){
    polylines.forEach(item => index.removeLayer(item))
    markers.forEach(item => index.removeLayer(item))
}

function endSelected() {
    var text = end.options[end.selectedIndex].text;
    drawLocation(text, data => {
        endCordLat.value = data.lat
        endCordLon.value = data.lon
    })
}

function startSelected() {
    var text = start.options[start.selectedIndex].text;
    drawLocation(text, data => {
        startCordLat.value = data.lat
        startCordLon.value = data.lon
    })
}

function drawLocation(name, cb) {
    fetch('http://localhost:8080/street?' + new URLSearchParams({
        name: name
    })).then(res => {
        res.json().then(data => {
            const m = L.marker(data).addTo(index);
            markers.push(m)
            cb(data)
        })
    })
}

function searchStreetName() {
    fetch('http://localhost:8080/streets?' + new URLSearchParams({
        query: streetname.value
    })).then(res => {
        res.json().then(data => {
            const fillStart = start.innerHTML.length === 0
            const fillEnd = end.innerHTML.length === 0
            for (name of data) {
                const option = document.createElement("option")
                const option2 = document.createElement("option")
                option.value = index
                option.innerHTML = name
                option2.value = index
                option2.innerHTML = name
                if (fillStart) start.appendChild(option)
                else if (fillEnd) end.appendChild(option2)
            }
        })
    })
}

function searchBestRoute() {
    fetch('http://localhost:8080/route?' + new URLSearchParams({
        start: start.options[start.selectedIndex].text,
        end: end.options[end.selectedIndex].text
    })).then(res => {
        res.json().then(data => {
            const line = L.polyline(data, {weight: 3, color: 'red'}).addTo(index)
            polylines.push(line)
        })
    })
}
