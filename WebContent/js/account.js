function login(){
	setCookie("isLogged",true,1);
	location.reload();
	
}

function logout(){
	deleteCookie("isLogged");
	location.reload();
	
}

function loadNavbar(loged){
    if(loged){
    	document.getElementById('notification').style.display ='block';
        document.getElementById('payment').style.display ='block';
        document.getElementById('search').style.display ='block';
        document.getElementById('account').style.display ='block';
        document.getElementById('live').style.display ='block';
        document.getElementById('login').style.display ='none';
        document.getElementById('register').style.display ='none';
    }else{
    	document.getElementById('notification').style.display ='none';
        document.getElementById('payment').style.display ='none';
        document.getElementById('search').style.display ='none';
        document.getElementById('account').style.display ='none';
        document.getElementById('live').style.display ='none';
        document.getElementById('login').style.display ='block';
        document.getElementById('register').style.display ='block';
        
    }
}


var loged = getCookie('isLogged');
loadNavbar(loged);