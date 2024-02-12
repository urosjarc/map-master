// Where you want to render the map.
var element = document.getElementById('osm-map');
const streetname = document.getElementById('streetname')
const start = document.getElementById('start')
const end = document.getElementById('end')

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
            L.polyline(line).addTo(index)
        }
    })
})

function clearStart() {
    start.innerHTML = ''
}

function clearEnd() {
    end.innerHTML = ''
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
                if (fillEnd) end.appendChild(option)
            }
        })
    })
}
