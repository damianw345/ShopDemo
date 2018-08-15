let baseUrl = 'http://localhost:8080/';

getIngredients('GET', baseUrl, 'dressings');
getIngredients('GET', baseUrl, 'flavours');
getIngredients('GET', baseUrl, 'sauces');

// Create the XHR object. 
function createCORSRequest(method, url) {
    var xhr = new XMLHttpRequest();
    if ("withCredentials" in xhr) {
        // XHR for Chrome/Firefox/Opera/Safari.
        xhr.open(method, url, true);
    } else if (typeof XDomainRequest != "undefined") {
        // XDomainRequest for IE.
        xhr = new XDomainRequest();
        xhr.open(method, url);
    } else {
        // CORS not supported.
        xhr = null;
    }
    return xhr;
}

// Make the actual CORS request.
function getIngredients(method, baseUrl, endpoint) {
    var xhr = createCORSRequest(method, baseUrl + endpoint);
    if (!xhr) {
        alert('CORS not supported');
        return;
    }

    // Response handlers.
    xhr.onload = function () {

        var responseText = xhr.responseText;
        if (method === 'GET') {
            // return JSON.parse(responseText);
            createUlFromJsonArr(JSON.parse(responseText), endpoint);
        }
    };

    xhr.onerror = function () {
        alert('There was an error making the request.');
    };
    xhr.send();
}

function getOrders(method, baseUrl, endpoint, filter) {
    var xhr = createCORSRequest(method, baseUrl + endpoint + '?filter=' + filter);
    if (!xhr) {
        alert('CORS not supported');
        return;
    }

    // Response handlers.
    xhr.onload = function () {

        var responseText = xhr.responseText;
        if (method === 'GET') {
            alert(responseText);


        }
    };

    xhr.onerror = function () {
        alert('There was an error making the request.');
    };
    xhr.send();
}

function createUlFromJsonArr(array, forEndpoint) {

    for (var i = 0; i < array.length; i++) {
        // alert(dressing.dressingName);
        addItemToUlFromJson(array[i], forEndpoint);
    }
}

//json object has properties:
//endpoint without last char + Id
//endpoint without last char + Name
function addItemToUlFromJson(json, forEndpoint) {
    // var ul = document.getElementById("dynamic-dressings");
    var ul = document.getElementById("dynamic-" + forEndpoint);
    var li = document.createElement("li");

    let endpointWithoutLastChar = forEndpoint.substring(0, forEndpoint.length - 1);
    li.setAttribute('id', endpointWithoutLastChar + "Name");
    li.appendChild(document.createTextNode(json[endpointWithoutLastChar + "Name"]));
    ul.appendChild(li);
}

// function removeItem() {
//     var ul = document.getElementById("dynamic-list");
//     var candidate = document.getElementById("candidate");
//     var item = document.getElementById(candidate.value);
//     ul.removeChild(item);
// }