/**
 * 
 */
window.onload = () => {
    const pictureArea = document.getElementById("picture_in_gallery")

    const images = document.querySelectorAll("#picture_in_gallery img")
    console.log(images)

    let timeElasped = 0;

    const timerId = setInterval( ()=>{
        timeElasped ++
        let visible = timeElasped % 3
        for(let i=0; i<3; i++ ){
            images[i].style.display = "none"
        }
        images[visible].style.display = "block"
   
    }, 3000)



}

const onMoveMemberBoard = (event) => {
	event.preventDefault()
	
	const btnLogin = document.getElementById("btnLogin")
	if(btnLogin.textContent.includes("logout")){
		console.log("login State")
		window.location.href = "/MyProject/read.board"
	} else {
		console.log("logout State")
		window.alert("멤버 페이지 입니다")
	}
	
}