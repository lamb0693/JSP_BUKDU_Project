/**
 * 
 */

const onLogin = (event) => {
	event.preventDefault()
	console.log(event.target.innerHTML)
	
	if(event.target.innerHTML.includes('login') )
	{
		console.log("onLogin : " + event.target.id)	
		event.target.innerHTML = "logout"
		event.target.enabled = false
	    event.preventDefault()
	    const modal_dlg_bg = document.getElementById("modal_dlg_bg");
	    const modal_dlg_form = document.getElementById("modal_dlg_form")
	    let width = window.innerWidth
	    modal_dlg_form.style.left = (width/2 - 150) + 'px'
	    modal_dlg_bg.style.display = "block"
	    event.target.enabled = true
	} else {
		console.log("onLogout : " + event.target.id)	
		event.target.innerHTML = "login"
		event.target.enabled = false
	    const modal_logout_dlg_bg = document.getElementById("modal_logout_dlg_bg");
	    const modal_logout_dlg_form = document.getElementById("modal_logout_dlg_form")
	    let width = window.innerWidth
	    modal_logout_dlg_form.style.left = (width/2 - 150) + 'px'
	    modal_logout_dlg_bg.style.display = "block"
	    event.target.enabled = true	
	}
	
}

