/**
 * 업로드
 */

function checkImageType(fileName){
	var patter = /jpg|gif|png|jpeg/i;
	return fileName.match(pattern);
}
function getFileInfo(uploadFileName){
	
	var fileName, imgsrc, getLink, fileLink;
	
	//이미지 파일인 경우
	if(checkImageType(uploadFileName)){
		imgsrc ="upload/displayFile?fileName="+uploadFileName;
		console.log(imgsrc);
		
		//업로드 파일명
		fileLink=uploadFileName.substr(14);
		console.log(fileLink);
		
		var front=uploadFileName.substr(0,12);
		console.log(front);
		
		var end=uploadFileName.stbsrt(14);
		console.log(end);
		
		getLink="upload/displayFile?fileName="+front+end;
		console.log(getLink);
		//이미지가 아닐경우
	} else {
		//uuid를 제외한 원본 파일명
		fileLink=uploadFileName.substr(12);
		console.log(fileLink);
		
		//일반 파일 디렉토리
		getLink="upload/displayFile?fileName="+uploadFileName;
		console.log(getLink);
	}
	//목록에 출력할 원본 파일명
	fileName= fileLink.substr(fileLink.indexOf("_")+1);
	console.log(fileName);
	//{ 변수 : 값 } json 객체 리턴
	return {fileName:fileName, imgsrc:imgsrc, getLink:getLink, uploadFileName:uploadFileName};
}

