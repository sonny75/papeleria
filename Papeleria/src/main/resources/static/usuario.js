document.addEventListener("DOMContentLoaded", () => {
    const usuario = document.querySelector("#usuario");
    const usuarioForm = document.querySelector("#create-usuario");
    console.log("Lo que trae la variable:",usuarioForm);
     //console.log("Lo que trae la variable:",usuario);
   usuarioForm.addEventListener('submit', createUsuario);
    fetch("http://localhost:8080/usuario/list")
            .then(response => response.json())
     //.then(response=> console.log(response))
            .then(usuario=> usuario.forEach(slapItOnTheDOM))
    //.then(console.log())
    function slapItOnTheDOM(usuario) {
        //console.log("Inicia mostrando el listado de usuarios");
        const usuarioLi = document.createElement("li");
        usuarioLi.dataset.idusuario = usuario.idusuario;
        usuarioLi.innerHTML = '<span>' +usuario.nombbreuno 
                + '-' + usuario.nombredos +'-'
                + usuario.apellidouno
                + '-' + usuario.apellidodos
                + '-' + usuario.celular
                + '-' + usuario.direcccion
                + '-' + usuario.email
                + '-' + usuario.rol;
        '</span>';
        usuario.appendChild(usuarioLi);
        //console.log("Identificador de usuario", usuarioLi.dataset.id); 
    }
     function createUsuario(event) {
        console.log('Inicia creacion');
        event.preventDefault();
        let nuevoUsuario = reunirFormData();
        return fetch("http://localhost:8080/usuario/",{
            method:"POST",
            headers: {
                'Content-Type':'application/json',
                'Accept':'application/json'
            },

            body: JSON.stringify(nuevoUsuario)
        })
                .then(res => res.json())
               .then(usuario => (slapItOnTheDOM(usuario)))
       
    }
    function reunirFormData() {
        return{
            idusuario: event.target.idusuario.value,
            nombre_uno: event.target.nombreuno.value,
            nombredos: event.target.nombredos.value,
            apellidouno: event.target.apellidouno.value,
            apellidos: event.target.apellidodos.value,
            celular: event.target.celular.value,
            direccion: event.target.direccion.value,
            email: event.target.email.value,
            rol: event.target.rol.value
        }
    }
})

    


