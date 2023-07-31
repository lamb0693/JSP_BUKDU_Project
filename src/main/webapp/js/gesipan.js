/**
 * 
 */
 
 // 원글 modify  -- modify form setup만 시키고  삭제는 form에서 한다
 const modifyBoard = (event, content, id) => {
	 event.preventDefault()

	 document.getElementById("modify_content").value = content;
	 document.getElementById("modify_id").value = id

	 
	 const modal_dlg_bg = document.getElementById("modal_modify_board_bg");
	 const modal_dlg_form = document.getElementById("modal_modify_board");
	 
	 let width = window.innerWidth
	 modal_dlg_form.style.left = (width/2 - 190) + 'px'
	 modal_dlg_bg.style.display = "block"
	  
 }
 
  const deleteBoard = (event) => {
	 const id = event.target.id;
	 numId = id.substring(4) // string 보내나 숫자 보내나 
	 console.log(numId)
	 window.location.href = ("/MyProject/delete.board?board_id="+numId)
 }
 
 const closeModifyPopup = (event) => {
	 console.log(event);
	 document.getElementById("modal_modify_board_bg").style.display = "none";	 
 }
 
 const saveModified = (event) => {
	 event.preventDefault()
	 //console.log(event.target)
	 const form = document.getElementsByClassName("myFormGeneral")[0];
	 console.log(form);
	 const id = document.getElementById("modify_id").value
	 const content = document.getElementById("modify_content").value
	 
	 form.action = form.action = "/MyProject/update.board?modify_id=" + id + "&content=" + content 
	 form.submit();
 }
 


 const open_close_reply = (event, id) => {
	 event.preventDefault()
	 let reply_area = "reply_area" + id
	 const replyArea = document.getElementById(reply_area)
	 console.log(event.target, event.target.textContent)
  	 //console.log(textBetweenTags)
	 if(event.target.textContent == '댓글열기'){
		  event.target.textContent='댓글닫기'
		  replyArea.style.display = "block"
	 }
	 else{
	 	event.target.textContent='댓글열기'
	 	replyArea.style.display = "none"	 
	 } 
	 
	 // 글 마다 댓글을 만들어 놓고, disply none  block만 반복
 }

 
 const saveReply = (event)=> {
	 console.log("save Reply")
 }