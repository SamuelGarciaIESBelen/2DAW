// Funcion que captura los valores de un formulario pasados por get
function obtenerGET()
{
	// Capturamos la url
	var loc = document.location.href;
	// Si existe el signo de interrogacion
	if (loc.indexOf('?') > 0)
	{
		// Cogemos la parte de la url despues de ?
		var getString = loc.split('?')[1];
		// obtenemos un array con cada nombre=valor
		var GET = getString.split('&');
		var get = {};
		
		// Recorremos todo el array de valores
		for(var i = 0, l = GET.length; i < l; i++) 
		{
			var tmp = GET[i].split('=');
			get[tmp[0]] = unescape(decodeURI(tmp[1]));
		}
			return get;
	}
}
window.onload = function()
{
	// Obtenemos los valores pasados por GET
	var valores = obtenerGET();
	if (valores)
	{
		// Con un bucle recorremos el array
		for (var index in valores)
		{
			document.write("<br> Control: " + index + " - Valor: "+ valores[index]);
		}
	} else {
		// No se ha recibido ningun parametro por GET
		document.write("No se ha recibido ningun parametro.");
	}
}