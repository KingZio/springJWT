function getCookie(name) {
    const value = `; ${document.cookie}`;
    const parts = value.split(`; ${name}=`);
    if (parts.length === 2) return parts.pop().split(';').shift();
}
const token = getCookie('jwtToken');
if (token) {
    alert("Already Logged in")
    window.location.href="/"
} else {
    console.log("토큰 없음.")
}