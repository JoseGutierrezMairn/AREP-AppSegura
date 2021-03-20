var apiclient = (function (){

    var url = "https://localhost:5000";
	var valido = {correo:"jose@email.com", pw:"jose123"};
	
	function login(){
        var usuario = {email:document.getElementById("correoUsuario").value, pw:document.getElementById("contraseñaUsuario").value};
		
		if(valido.correo == usuario.email && valido.pw == usuario.pw ){
			
			axios.post(url+"/login",usuario).then(res=>{
				window.location.href="authentication.html";
			})
			
		}else{
			alert("Usuario o contraseña no encontrados");
		}
        
    }

    return {
        login : login
    };
})();