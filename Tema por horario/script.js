var imagem = window.document.getElementById("imagem")
var mensagem = window.document.getElementById("mensagem")
var titulo = window.document.getElementById("titulo")
var favicon = window.document.getElementById("favicon")
var data = new Date()
var hora = data.getHours()
if(hora >= 5 && hora <= 13){
    titulo.innerHTML = "DIA"
    mensagem.innerHTML = `Bom dia!<br/>São ${hora} horas.`
    imagem.src = 'dia.jpg'
    document.body.style.background = 'rgb(36, 255, 200)'
}
if(hora > 13 && hora < 18){
    titulo.innerHTML = "TARDE"
    mensagem.innerHTML = `Boa tarde!<br/>São ${hora} horas.`
    imagem.src = 'tarde.png'
    document.body.style.background = 'rgb(255, 178, 36)'
}
if(hora >= 18 && hora <= 24){
    titulo.innerHTML = "NOITE"
    mensagem.innerHTML = `Boa noite!<br/>São ${hora} horas.`
    imagem.src = 'noite.jpg'
    document.body.style.background = 'rgb(0, 0, 50)'
    document.body.style.color = 'white'
    mensagem.style.color = 'black'
}
if(hora >= 0 && hora < 5){
    titulo.innerHTML = "MADRUGADA"
    mensagem.innerHTML = `É madrugada...<br/>São ${hora} horas.`
    imagem.src = 'madrugada.jpg'
    document.body.style.background = 'rgb(0, 0, 20)'
    document.body.style.color = 'white'
    mensagem.style.color = 'black'
    if(hora == 0){
        mensagem.innerHTML = `É madrugada...<br/>É ${hora}, meia-noite.`
    }
    if(hora == 1){
        mensagem.innerHTML = `É madrugada...<br/>É ${hora} hora.`
    }
    else{
        mensagem.innerHTML = `É madrugada...<br/>São ${hora} horas.`
    }
}
if(hora >= 5 && hora < 17){
    favicon.setAttribute("href", "Favicon/Dapino-Summer-Holiday-Sun.ico")
}
if(hora < 5 || hora >= 17){
    favicon.setAttribute("href", "Favicon/Pelfusion-Christmas-Shadow-2-Moon.ico")
}