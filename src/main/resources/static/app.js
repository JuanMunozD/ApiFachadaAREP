var nameButton = document.getElementById("buttonName");
var url = "/Apps/hello?value=";

nameButton.addEventListener('click', function () {
    $("#hello").empty();
    var numero = document.getElementById("numero").value;
    var operacion = document.getElementById("operacion").value;
    if(numero==="" || operacion===""){
        alert("Please insert a name");
    } else {
        axios.get("http://localhost:4444/"+operacion+"?value="+numero)
            .then(res => {
                console.log(res);
                $("#hello").append(res.data.respuesta);
            }).catch(err => {
                console.log(err);
        });
    }
});