document.addEventListener("DOMContentLoaded",() =>{
    const ventas = document.querySelector("#ventas");
    const ventasForm = document.querySelector("#create-ventas");
    console.log("Lo que trae la variable:",ventasForm);
    //console.log("Lo que trae la variable:",ventas);
    ventasForm.addEventListener('submit', createVentas);
    fetch("http://localhost:8080/ventas/list")
            .then(response => response.json())
            //.then(response=> console.log(response))
            .then(ventas => ventas.forEach(slapItOnTheDOM))
            //.then(console.log())
    function slapItOnTheDOM(ventas){
        //console.log("Inicia mostrando el listado de ventas");
        const ventasLi = document.createElement("li");
        ventasLi.dataset.idventas = ventas.idventas;
        ventasLi.innerHTML = '<span>'+ventas.papeleria.idpapeleria
                + '-' + ventas.usuario.idusuario
                + '-' + ventas.rol.id 
                +'</span>';
        ventas.appendChild(ventasLi);
        //console.log("Identificador de ventas", productoLi.dataset.id);
    }
    function createVentas(event){
        console.log("inicia creacion");
        event.preventDefault();
        let nuevoventas=reunirFormData();
        return fetch("http://localhost:8080/ventas/",{
            method:"POST",
            headers:{
                'Content-Type':'application/json',
                'Accept':'application/json'
            },
            body:JSON.stringify(nuevoventas)
        })
                .then(res => res.json())
                .then(ventas => (slapItOnTheDOM(ventas)))
    }
    function reunirFormData(){
        return {
            idventa:event.target.idventa.value,
            papeleria:{idpapeleria:event.target.idpapeleria.value},
            usuario:{idusuario:event.target.idusuario.value},
            rol:{id:event.target.id.value}
            
        }
    }
})