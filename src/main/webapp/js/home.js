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

	const socket = io("http://localhost:3000", {
	});
			
	const messages = document.getElementById('chat_window');
	console.log(messages)
	const form = document.getElementById('chatting_form');
	const input = document.getElementById('chat_message');
	const chat_div = document.getElementById("chatting_div")
	const id_span = document.getElementById("chat_id")

	if(id_span.innerHTML != ""){
		form.addEventListener('submit', function(e) {
		e.preventDefault();
		if (input.value) {
			message = id_span.innerHTML + ' : ' + input.value
			socket.emit('chat message', message);
			input.value = '';
		}
		});	
	
		socket.on('chat message', function(msg) {
			var item = document.createElement('li');
			item.textContent = msg;
			messages.appendChild(item);
			//chat_div.scrollTo(0, chat_div.scrollHeight);
		});	
	}



}
