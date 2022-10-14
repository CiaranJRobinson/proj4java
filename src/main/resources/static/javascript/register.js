const registerForm = document.getElementbyId('register-form')
const registerUsername = document.getElementbyId('register-username')
const registerPassword = document.getElementbyId('register-password')

const headers = {
    'Content-type':'application/json'
}

const baseUrl = 'http://localhost:8080/api/v1/users'

const handleSubmit = async (e) =>{
    e.preventDefault()

    let bodyObj = {
        username: registerUsername.value,
        password: registerPassword.value
    }

    const response = await fetch(`${baseUrl}/register`, {
        method: "POST",
        body: JSON.stringify(bodyObj),
        headers: headers
    })
        .catch(err => console.error(err.message))

    const responseArr = await response.json()

    if (response.status === 200){
        window.location.replace (responseArr[0])
        }

}

registerForm.addEventListener("submit", handleSubmit)