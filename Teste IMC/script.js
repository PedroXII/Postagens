    function calcular(){
    var imagem = window.document.getElementById('imagem')
    var mensagem = window.document.getElementById('resultado')
    var agora = new Date()
    var getNasc = window.document.getElementById('nasc')
    var nasc = getNasc.value
    var nascdate = new Date(nasc)
    var dia = agora.getDate()
    var mes = agora.getMonth() + 1
    var ano = agora.getFullYear()
    var dian = nascdate.getDate() + 1
    var mesn = nascdate.getMonth() + 1
    var anon = nascdate.getFullYear()
    var idade = Number.parseInt((((31 - dian) + (365 - (mesn + 1) * 30) + (ano - anon - 1) * 365 + dia + (mes * 30)) / 365))
    var button = window.document.getElementsByName('sex')
    var sexo = ''
    var imagem = document.createElement('img', 'estado') //O elemento 'imagem' foi criado no próprio Javascript, 'estado' é o ID.
    if(button[0].checked){
        sexo = 'Masculino'
    }
    else if(button[1].checked){
        sexo = 'Feminino'
    }
    var varpeso = window.document.getElementById('peso')
    var varaltura = window.document.getElementById('altura')
    var getPeso = varpeso.value
    var getAltura = varaltura.value
    var peso = Number(getPeso)
    var altura = Number(getAltura)
    var imc = (peso / (altura * altura))
    if(altura <= 0 || peso <= 0 || sexo == '' || idade < 0){
        mensagem.innerHTML = `Preencha todos os dados e tente novamente`
    }
    else{
        if(imc < 18.5){
            imagem.setAttribute('src', 'abaixo-do-peso.png')
            mensagem.innerHTML = `Você tem ${idade} anos, seu sexo é ${sexo},<br/> tem ${altura} metros de altura, pesa ${peso} quilos <br/> e seu IMC é: <strong>${imc}</strong><br/>`
        }
        if(imc >= 18.5 && imc < 24.9){
            imagem.setAttribute('src', 'peso-normal.png')
            mensagem.innerHTML = `Você tem ${idade} anos, seu sexo é ${sexo},<br/> tem ${altura} metros de altura, pesa ${peso} quilos <br/> e seu IMC é: <strong>${imc}</strong><br/>`
        }
        if(imc >= 25 && imc < 29.9){
            imagem.setAttribute('src', 'sobrepeso.png')
            mensagem.innerHTML = `Você tem ${idade} anos, seu sexo é ${sexo},<br/> tem ${altura} metros de altura, pesa ${peso} quilos <br/> e seu IMC é: <strong>${imc}</strong><br/>`
        }
        if(imc >= 30 && imc < 34.9){
            imagem.setAttribute('src', 'obesidade-grau1.png')
            mensagem.innerHTML = `Você tem ${idade} anos, seu sexo é ${sexo},<br/> tem ${altura} metros de altura, pesa ${peso} quilos <br/> e seu IMC é: <strong>${imc}</strong><br/>`
        }
        if(imc >= 35 && imc < 39.9){
            imagem.setAttribute('src', 'obesidade-grau2.png')
            mensagem.innerHTML = `Você tem ${idade} anos, seu sexo é ${sexo},<br/> tem ${altura} metros de altura, pesa ${peso} quilos <br/> e seu IMC é: <strong>${imc}</strong><br/>`
        }
        if(imc >= 40){
            imagem.setAttribute('src', 'obesidade-grau3.png')
            mensagem.innerHTML = `Você tem ${idade} anos, seu sexo é ${sexo},<br/> tem ${altura} metros de altura, pesa ${peso} quilos <br/> e seu IMC é: <strong>${imc}</strong><br/>`
        }
    }
    mensagem.appendChild(imagem)
}