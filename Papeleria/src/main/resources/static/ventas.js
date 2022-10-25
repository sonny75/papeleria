document.addEventListener("DOMContentLoaded", () => {
    const ventas = document.querySelector("#ventas");
    const ventasForm = document.querySelector("#create-ventas");
    console.log("Lo que trae la variable:", ventasForm);
    //console.log("Lo que trae la variable:",ventas);
   ventasForm.addEventListener('submit', createVentas);
    fetch("http://localhost:8080/ventas/list")
            .then(response => response.json())
            //.then(response=> console.log(response))
            .then(ventas => ventas.forEach(slapItOnTheDOM))
    //.then(console.log())
    function slapItOnTheDOM(ventas) {
        //console.log("Inicia mostrando el listado de roles");
        const ventasLi = document.createElement("li");
       ventasLi.dataset.idVentas = ventas.idventas;
       ventasLi.innerHTML = '<span>' +ventas.idpapeleria 
                + '-' + ventas.idusuario +'-'
                + ventas.fecharegistro
                + '-' 
        '</span>';
       ventas.appendChild(ventasLi);
        //console.log("Identificador de Rol", rolLi.dataset.id); 
    }
    function createVentas(event) {
        console.log('Inicia creacion');
        event.preventDefault();
        let nuevoVentas = reunirFormData();
        return fetch("http://localhost:8080/ventas/",{
            method:"POST",
            headers: {
                'Content-Type':'application/json',
                'Accept':'application/json'
            },

            body: JSON.stringify(nuevoVentas)
        })
                .then(res => res.json())
               .then(ventas => (slapItOnTheDOM(ventas)))
    }
    function reunirFormData() {
        return{
            idvetnas: event.target.idventas.value,
            idpapeleria: event.target.idpapeleria.value,
            idusuario: event.target.idusuario.value,
            emailproveedor: event.target.emailproveedor.value,
            fecharegistro: event.target.fecharegistro.value
           
        }
    }
})


