function postOrder(baseUrl, endpoint) {

    var xhr = createCORSRequest('POST', baseUrl + endpoint);

    xhr.setRequestHeader("Content-type", "application/json");
    let json = {
            "iceCreams": [
                {
                    dressing: "Jagody",
                    flavours: [
                        "Malina",
                        "Bounty",
                    ],
                    sauce: "Toffi"
                }
            ],
            "isFinished": true,
        }

        xhr.send(JSON.stringify(json));
}