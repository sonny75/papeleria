document.addEventListener("DOMContentLoaded",() =>{
    const papelerias = document.querySelector("#papelerias");
    const papeleriaForm = document.querySelector("#create-papeleria");
    console.log("Lo que trae la variable:",papeleriaForm);
    //console.log("Lo que trae la variable:",papeleria);
    papeleriaForm.addEventListener('submit', createPapeleria);
    fetch("http://localhost:8080/papeleria/list")
            .then(response => response.json())
            //.then(response=> console.log(response))
            .then(papeleria => papeleria.forEach(slapItOnTheDOM))
            //.then(console.log())
    function slapItOnTheDOM(papeleria){
        //console.log("Inicia mostrando el listado de papelerias");
        const papeleriaLi = document.createElement("li");
        papeleriaLi.dataset.idPapeleria = papeleria.idpapeleria;
        papeleriaLi.innerHTML = '<span>'+papeleria.nombrepapeleria + '-' + papeleria.celularpapeleria + '-' + papeleria.direccionpapeleria +'</span>';
        papelerias.appendChild(papeleriaLi);
        //console.log("Identificador de Rol", rolLi.dataset.id);
    }
    function createPapeleria(event){
        console.log("inicia creacion");
        event.preventDefault();
        let nuevopapeleria=reunirFormData();
        return fetch("http://localhost:8080/papeleria/",{
            method:"POST",
            headers:{
                'Content-Type':'application/json',
                'Accept':'application/json'
            },
            body:JSON.stringify(nuevopapeleria)
        })
                .then(res => res.json())
                .then(papeleria => (slapItOnTheDOM(papeleria)))
    }
    function reunirFormData(){
        return {
            idpapeleria:event.target.idpapeleria.value,
            nombrepapeleria:event.target.nombrepapeleria.value,
            celularpapeleria:event.target.celularpapeleria.value,
            direccionpapeleria:event.target.direccionpapeleria.value
        }
    }
})











