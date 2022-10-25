document.addEventListener("DOMContentLoaded",() =>{
    const roles = document.querySelector("#roles");
    const rolForm = document.querySelector("#create-rol");
    console.log("Lo que trae la variable:",rolForm);
    //console.log("Lo que trae la variable:",proveedores);
    rolForm.addEventListener('submit', createRol);
    fetch("http://localhost:8080/rol/list")
            .then(response => response.json())
            //.then(response=> console.log(response))
            .then(rol => rol.forEach(slapItOnTheDOM))
            //.then(console.log())
    function slapItOnTheDOM(rol){
        //console.log("Inicia mostrando el listado de roles");
        const rolLi = document.createElement("li");
        rolLi.dataset.id = rol.id;
        rolLi.innerHTML = '<span>'+rol.nombre;//+ '-' + proveedor.email_proveedor + '</span>';
        roles.appendChild(rolLi);
        //console.log("Identificador de Rol", rolLi.dataset.id);
    }
    function createRol(event){
        console.log("inicia creacion");
        event.preventDefault();
        let nuevoRol=reunirFormData();
        return fetch("http://localhost:8080/rol/",{
            method:"POST",
            headers:{
                'Content-Type':'application/json',
                'Accept':'application/json'
            },
            body:JSON.stringify(nuevoRol)
        })
                .then(res => res.json())
                .then(rol => (slapItOnTheDOM(rol)))
    }
    function reunirFormData(){
        return {
            id:event.target.id.value,
            nombre:event.target.nombre.value
        }
    }
})


