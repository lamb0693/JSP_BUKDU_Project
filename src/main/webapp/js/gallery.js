/**
 * 
 */
const onUploadImage = (event) => {
		event.preventDefault()
	    // login창 입력 검정 과정
	    const dlgFile = document.getElementById("up_file")
	    const form = document.getElementById("upload_form")
	    
	    if(dlgFile.files.length > 0){
			filename = dlgFile.files[0].name
			console.log(filename)
			
			const dot = filename.lastIndexOf('.');
 
    		// 확장자 명만 추출한 후 소문자로 변경
    		const extension = filename.substring(dot, filename.length).toLowerCase();
    		console.log(extension)
			
			allow = ['.jpg', '.jpeg', '.gif', '.bmp', '.png']
			allowed = false
			for(i=0; i<allow.length; i++){
				if(extension === allow[i]) {
					allowed= true;
					break;
				}
			}
			if(allowed) {
				form.submit();
			} else {
				alert("jpg, jpeg, gif, bmp, png 만 가능합니다")	
			}
		} else {
			alert("file을 먼저 선택하세요")
			return
		}	
		
}