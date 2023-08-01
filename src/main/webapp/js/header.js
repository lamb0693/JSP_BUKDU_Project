/**
 * 
 */

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

const onMoveGallery = (event) => {
	event.preventDefault()
	
	const btnLogin = document.getElementById("btnLogin")
	if(btnLogin.textContent.includes("logout")){
		console.log("login State")
		window.location.href = "/MyProject/read.gallery"
	} else {
		console.log("logout State")
		window.alert("멤버 페이지 입니다")
	}	
}

const onLogin = (event) => {
	event.preventDefault()
	console.log(event.target.innerHTML)
	
	if(event.target.innerHTML.includes('login') )
	{
		console.log("onLogin : " + event.target.id)	
		event.target.enabled = false
	    event.preventDefault()
	    const modal_dlg_bg = document.getElementById("header_modal_login_bg");
	    const modal_dlg_form = document.getElementById("header_modal_login_form")
	    let width = window.innerWidth
	    modal_dlg_form.style.left = (width/2 - 150) + 'px'
	    modal_dlg_bg.style.display = "block"
	    event.target.enabled = true
	} else {
		console.log("onLogout : " + event.target.id)	
		event.target.enabled = false
	    const modal_logout_dlg_bg = document.getElementById("header_modal_logout_bg");
	    const modal_logout_dlg_form = document.getElementById("header_modal_login_form")
	    let width = window.innerWidth
	    modal_logout_dlg_form.style.left = (width/2 - 150) + 'px'
	    modal_logout_dlg_bg.style.display = "block"
	    event.target.enabled = true	
	}
	
}

const closeLoginPopup = (event) => {
	event.preventDefault();
	const modal_dlg_bg = document.getElementById("header_modal_login_bg");
	modal_dlg_bg.style.display = "none";
}

const closeLogoutPopup = (event) => {
	event.preventDefault()
	const modal_dlg_bg = document.getElementById("header_modal_logout_bg");
	modal_dlg_bg.style.display = "none";
}


const openSignonPopup = (event) => {
	event.preventDefault()
    const modal_dlg_bg = document.getElementById("header_modal_signon_bg");
    const modal_dlg_form = document.getElementById("header_modal_signon_form")
    let width = window.innerWidth
    modal_dlg_form.style.left = (width/2 - 150) + 'px'
    modal_dlg_bg.style.display = "block"
}

const closeSingonPopup = (event) => {
	event.preventDefault()
	const modal_dlg_bg = document.getElementById("header_modal_signon_bg");
	modal_dlg_bg.style.display = "none";	
}

const openModifyInfoPopup = (event, user_id, user_name, user_tel) => {
	event.preventDefault()
    const modal_dlg_bg = document.getElementById("header_modal_modify_info_bg");
    const modal_dlg_form = document.getElementById("header_modal_modify_info_form")
    document.getElementById("id_modify").value = user_id
    document.getElementById("name_modify").value = user_name
    document.getElementById("tel_modify").value = user_tel
    let width = window.innerWidth
    modal_dlg_form.style.left = (width/2 - 150) + 'px'
    modal_dlg_bg.style.display = "block"
}

const closeModifyInfoPopup = (event) => {
	event.preventDefault()
	const modal_dlg_bg = document.getElementById("header_modal_modify_info_bg");
	modal_dlg_bg.style.display = "none";	
}