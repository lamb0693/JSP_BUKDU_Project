/**
 * 
 */

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