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

// login시 입력 내용 검증
const checkLoginIdPwd = (event) => {
		event.preventDefault()
	    // login창 입력 검정 과정
	    const txtId = document.getElementById("login_id")
	    const txtPwd = document.getElementById("login_password")
	    const form = document.getElementById("header_myFormGeneral")
	    // 빈칸 있으면 return
	    if(txtId.value.length == 0 || txtPwd.value.length == 0){
			alert("id 와 password를 입력하세요")
			return
		} else {
			//없으면 submit
			form.submit()
		}			
}

const checkJoinonModal = (event) => {
		event.preventDefault()
	    // login창 입력 검정 과정
	    const txtId = document.getElementById("id_signon")
	    const txtPwd = document.getElementById("password_signon")
	    const txtName = document.getElementById("name_signon")
	    // const txtTel = document.getElementById("tel_signon") // tel은 null 가능
	    const form = document.getElementById("signon_form")
	    // 빈칸 있으면 return
	    if(txtId.value.length == 0 || txtPwd.value.length == 0 || txtName.value.length == 0){
			alert("id 와 password, 이름은 꼭 입력하셔야 합니다")
			return
		}
		if(txtId.value.length <6) {
			alert("id는 여섯자리 이상입니다")
			return
		}
		if( !checkIdString(txtId.value) ) {
			alert("id는 숫자, 영문 소문자, 대문자 만 가능합니다")
			return
		}
		if(txtPwd.value.length < 4 ) {
			alert("password 는 4자리 이상입니다")
			return
		}

		form.submit()
}



function checkIdString(strId){
	console.log(strId, strId.length)
	for(i=0; i<strId.length; i++){
		c = strId.charAt(i)
		if( ( c >= '0' && c <='9'  )  ||  ( c >= 'a' && c <='z') || ( c >= 'A' && c <='Z') )  continue;
		else return false
	}
	return true	
}

const checkModifyModal = (event) => {
		event.preventDefault()
	    // login창 입력 검정 과정
	    const txtPwd = document.getElementById("password_modify")
	    const txtName = document.getElementById("name_modify")
	    // const txtTel = document.getElementById("tel_signon") // tel은 null 가능
	    const form = document.getElementById("modify_form")
	    // 빈칸 있으면 return
	    if( txtPwd.value.length == 0 || txtName.value.length == 0){
			alert("password, 이름은 꼭 입력하셔야 합니다")
			return
		}
		if(txtPwd.value.length < 4 ) {
			alert("password 는 4자리 이상입니다")
			return
		}

		form.submit()
}

const onLogin = (event) => {
	event.preventDefault()
	console.log(event.target.innerHTML)
	
	if(event.target.innerHTML.includes('login') )
	{
		console.log("onLogin : " + event.target.id)	
		event.preventDefault()
		event.target.enabled = false

		// 입력 모달 창을 띄운다.
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