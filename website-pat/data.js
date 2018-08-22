//deklaracja obiektu glownego ZAMOWIENIE wysylanego do bazy danych. Sklada sie on z numeru zamowienia, trescie zamowienia, ceny oraz daty zamowienia
var objZamowienie = new Array;

//deklaracja pól obiektu glownego ZAMOWIENIE
var numerZamowienia=0;
var trescZamowienia;
var cenaZamowienia=0;
var dataZamowienia;

// DEKLARACJA OBIEKTÓW: SMAKI, DEKORACJE, POLEWA: tablica NAZWY ORAZ SMAKI
//smaki nazwa, czyDostepny, id z htmla
var banan = ["Banan","true", "banan"];
var biszkoptyBonitki = ["Biszkopty Bonitki","true", "biszkoptyBonitki"];
var bounty = ["Bounty","true", "bounty"];
var jagody = ["Jagody","true" ,"jagody"];
var kinderBueno = ["Kinder Bueno","true", "kinderBueno"];
var kinderMaxiKing = ["Kinder Maxi King","true", "kinderMaxiKing"];
var kinderPingui = ["Kinder Pingui","true", "kinderPingui"];
var malina = ["Malina","true", "malina"];
var michalki = ["Michałki z Hanki","true", "michalki"];
var michalkiMilk = ["Michałki z Hanki Milk","true", "michalkiMilk"];
var nescafe = ["Nescafe","true", "nescafe"];
var nutella = ["Nutella","true", "nutella"];
var oreo = ["Oreo","true", "oreo"];
var pastylkiMietowe = ["Pastylki Miętowe","true", "pastylkiMietowe"];
var pomarancza = ["Pomarańcza","true", "pomarancza"];
var princessa = ["Princessa","true", "princessa"];
var truskawka = ["Truskawka","true", "truskawka"];

//dekoracje
var hariboDekoracje = ["Haribo Złote Misie","true", "hariboDekoracje"];
var jagodyDekoracje = ["Jagody","true", "jagodyDekoracje"];
var malinyDekoracje = ["Maliny","true", "malinyDekoracje"];
var mandmDekoracje = ["M&M's","true", "mandmDekoracje"];
var rodzynkiDekoracje = ["Rodzynki","true", "rodzynkiDekoracje"];
var truskawkiDekoracje = ["Truskawki","true", "truskawkiDekoracje"];

//Polewa
var bitaSmietanaPolewa = ["Bita śmietana","true", "bitaSmietanaPolewa"];
var czekoladaPolewa = ["Czekoladowa","true", "czekoladaPolewa"];
var toffiPolewa = ["Toffi","true", "toffiPolewa"];
var truskawkaPolewa = ["Truskawkowa","true", "truskawkaPolewa"];

// deklaracja tablic typow, smakow, dodatkow
var arrSmaki = [banan, biszkoptyBonitki, bounty, jagody, kinderBueno, kinderMaxiKing, kinderPingui, malina, michalki, michalkiMilk, nescafe,
				nutella,oreo, pastylkiMietowe, pomarancza, princessa, truskawka];
var arrDekoracje = [hariboDekoracje, jagodyDekoracje, malinyDekoracje, mandmDekoracje, rodzynkiDekoracje, truskawkiDekoracje];
var arrPolewa = [bitaSmietanaPolewa, czekoladaPolewa, toffiPolewa, truskawkaPolewa];
//zmienna informujaca liczbe lodow w zamowieniu
var liczbaLodow = 0;
//zmienna informujaca ile smakow dobrano do loda - max 2 dekoracje max 2 polewa max 1
var liczbaSmakow= 0;
var liczbaDekoracji = 0;
var liczbaPolew = 0;
//zmienne blokujaca dodanie np. 2 wafelkow w jednym lodzie
var isTasteSet = false;
var isDekoracjaSet = false;
var isPolewaSet = false;

// tablica stringow dla zmiennej TRESC wykorzystywanej pozniej w glownym obiekcie ZAMOWIENIE
var iceCream = new Array();

// FUNKCJE -----------------------------------------------------------------------------------------------------------------------------------------

//funkcja wyboru dostepnych skladnikow dla lodow
function dostepneSkladniki(){
	document.querySelector("#noweZamowienieButton").style.display = "none";
	document.querySelector("#dostepneSkladnikiButton").style.display = "none";
}
//funkcja dodajaca nowe zamowienie, inkrementuje numer zamowienia, przechodzi do formy zamowienia
function noweZamowienie(){
	document.querySelector("#noweZamowienieButton").style.display = "none";
	document.querySelector("#zamowienieForm").style.display = "block";
	document.querySelector("#dostepneSkladnikiButton").style.display = "none";
	numerZamowienia++;
}
//funckja anulujaca zamowienie, przywraca panel pierwszy
function anulujZamowienie(){
	document.querySelector("#zamowienieForm").style.display = "none";
	document.querySelector("#noweZamowienieButton").style.display = "block";
	document.querySelector("#dostepneSkladnikiButton").style.display = "block";
	for(let j = 1 ; j <= liczbaLodow ; j++){
		document.getElementById("d"+j+"0").remove();
		document.getElementById("d"+j+"1").remove();
		document.getElementById("d"+j+"2").remove();
		document.getElementById("p"+j).remove();
		document.getElementById("l"+j).remove();
	}
	tescik[0]="";
	tescik[1]="";
	
	numerZamowienia--;
	liczbaLodow = 0;
	liczbaSmakow = 0;
	liczbaDekoracji = 0;
	liczbaPolew = 0;
}
// funckja wpisująca do elementow HTML dane pobrane z tablic obietkow lodow
window.onload = function() {

iceCream.push("Zamówienie");	

}
// funkcja ktora wypelnia nazwy skladnikow z js do html wywolywana w czasie tworzenia nowego zamowienia
function wypelnijNazwySkladnikow(){
	//smaki
	for(let i = 0 ; i < arrSmaki.length ; i++){
	document.getElementById(arrSmaki[i][2]).innerHTML = arrSmaki[i][0];
	}
	//dekoracje
	for(let i = 0 ; i < arrDekoracje.length ; i++){
	document.getElementById(arrDekoracje[i][2]).innerHTML = arrDekoracje[i][0];
	}
	//polewy
	for(let i = 0 ; i < arrPolewa.length ; i++){
	document.getElementById(arrPolewa[i][2]).innerHTML = arrPolewa[i][0];
	}
}
//funckja chowajaca przyciski i pokazujaca okno dodwania loda
function showLeftForm(){
	document.querySelector(".choose-window").style.display = "block";
	document.querySelector(".btn-dodaj-loda").style.display = "none";
	document.querySelector(".btn-anuluj-zamowienie").style.display = "none";
	document.querySelector(".btn-zloz-zamowienie").style.display = "none";
	
}
//funckja pokazujaca prawy panel, dodajaca obiekt loda
function addRightIceCream(){
	liczbaLodow++;
	
	var l = document.createElement("div");
	l.setAttribute("id", "l"+liczbaLodow);
	
	document.getElementById("right-side-form").appendChild(l);
	
	var p = document.createElement("p");
	p.setAttribute("id", "p"+liczbaLodow+"");
	p.style.color = "#facf5a";
	p.style.fontSize= "26px";
	p.innerHTML = "Lód numer " + liczbaLodow +":";
	
	
	document.getElementById("l"+liczbaLodow).appendChild(p);
	
	var d1 = document.createElement("div");
	d1.setAttribute("id", "d"+liczbaLodow+"0");
	var d2 = document.createElement("div");
	d2.setAttribute("id", "d"+liczbaLodow+"1");
	var d3 = document.createElement("div");
	d3.setAttribute("id", "d"+liczbaLodow+"2");
	
	var p1 = document.createElement("p");
	p1.innerHTML = "Smaki:";
	var p2 = document.createElement("p");
	p2.innerHTML = "Dekoracja:";
	var p3 = document.createElement("p");
	p3.innerHTML = "Polewa:";
	p1.style.color = "rgb(250, 207, 90)";
	p2.style.color = "rgb(250, 207, 90)";
	p3.style.color = "rgb(250, 207, 90)";
	p1.style.borderBottom = "1px solid rgb(250, 207, 90)";
	p2.style.borderBottom = "1px solid rgb(250, 207, 90)";
	p3.style.borderBottom = "1px solid rgb(250, 207, 90)";
	
	document.getElementById("l"+liczbaLodow).appendChild(d1);
	document.getElementById("l"+liczbaLodow).appendChild(d2);
	document.getElementById("l"+liczbaLodow).appendChild(d3);
	document.getElementById("d"+liczbaLodow+"0").appendChild(p1);
	document.getElementById("d"+liczbaLodow+"1").appendChild(p2);
	document.getElementById("d"+liczbaLodow+"2").appendChild(p3);
	
}
var tescik =["",""];
function addTaste(taste){
	
	if(liczbaSmakow<2 && tescik[0] != arrSmaki[taste][0] && tescik[1] != arrSmaki[taste][0]){
		isTasteSet = true;
		if(tescik[0]=="") tescik[0] = arrSmaki[taste][0];
		else tescik[1] = arrSmaki[taste][0];
		
		liczbaSmakow++;
		var d = document.createElement("div");
		d.className = "row";
		d.setAttribute("id", "dodanyElementSmaki"+liczbaLodow+taste);
		d.style.lineHeight = "30px";
		document.getElementById("d"+liczbaLodow+"0").appendChild(d);
		
		var nazwaPrawo = document.createElement("p");
		nazwaPrawo.style.color = "white";
		nazwaPrawo.className = "col-9";
		nazwaPrawo.innerHTML = arrSmaki[taste][0];
		document.getElementById("dodanyElementSmaki"+liczbaLodow+taste).appendChild(nazwaPrawo);
		
		var przyciskPrawo = document.createElement("div");
		przyciskPrawo.style.backgroundColor = "#f95959";
		przyciskPrawo.className = "col-3";
		przyciskPrawo.setAttribute("id", "smak1");
		przyciskPrawo.className = "smak"+liczbaLodow;
		przyciskPrawo.innerHTML = "Usuń";
		przyciskPrawo.onclick = function(){
			if(this.parentElement.childNodes[0].innerHTML == tescik[0]){
			this.parentElement.remove();
			tescik[0] = "";
			liczbaSmakow--;
		}
		if(this.parentElement.childNodes[0].innerHTML == tescik[1]){
			this.parentElement.remove();
			tescik[1] = "";
			liczbaSmakow--;
		}
		}
		document.getElementById("dodanyElementSmaki"+liczbaLodow+taste).appendChild(przyciskPrawo);
}
}
// add dekoracje
function addDekoracje(dekoracja){
	if(liczbaDekoracji < 1){
		liczbaDekoracji++;
		
		var d = document.createElement("div");
		d.className = "row";
		d.setAttribute("id", "dodanyElementDekoracje"+liczbaLodow+dekoracja);
		d.style.lineHeight = "30px";
		document.getElementById("d"+liczbaLodow+"1").appendChild(d);
		
		var nazwaPrawo = document.createElement("p");
		nazwaPrawo.style.color = "white";
		nazwaPrawo.className = "col-9";
		nazwaPrawo.innerHTML = arrDekoracje[dekoracja][0];
		document.getElementById("dodanyElementDekoracje"+liczbaLodow+dekoracja).appendChild(nazwaPrawo);
		
		var przyciskPrawo = document.createElement("div");
		przyciskPrawo.style.backgroundColor = "#f95959";
		przyciskPrawo.className = "col-3";
		przyciskPrawo.setAttribute("id", "smak1");
		przyciskPrawo.className = "deko"+liczbaLodow;
		przyciskPrawo.style.marginBottom = "10px";
		przyciskPrawo.style.borderRadius = "5px";
		przyciskPrawo.style.textAlign = "center";
		przyciskPrawo.style.color = "white";
		przyciskPrawo.innerHTML = "Usuń";
		przyciskPrawo.onclick = function(){
			this.parentElement.remove();
			liczbaDekoracji--;
		}
		document.getElementById("dodanyElementDekoracje"+liczbaLodow+dekoracja).appendChild(przyciskPrawo);

	}
}
//add polewa
function addPolewa(polewa){
	if(liczbaPolew < 1){
		liczbaPolew++;
		
		var d = document.createElement("div");
		d.className = "row";
		d.setAttribute("id", "dodanyElementPolewy"+liczbaLodow+polewa);
		d.style.lineHeight = "30px";
		document.getElementById("d"+liczbaLodow+"2").appendChild(d);
		
		var nazwaPrawo = document.createElement("p");
		nazwaPrawo.style.color = "white";
		nazwaPrawo.className = "col-9";
		nazwaPrawo.innerHTML = arrPolewa[polewa][0];
		document.getElementById("dodanyElementPolewy"+liczbaLodow+polewa).appendChild(nazwaPrawo);
		
		var przyciskPrawo = document.createElement("div");
		przyciskPrawo.style.backgroundColor = "#f95959";
		przyciskPrawo.className = "col-3";
		przyciskPrawo.setAttribute("id", "smak1");
		przyciskPrawo.className = "pole"+liczbaLodow;
		przyciskPrawo.style.marginBottom = "10px";
		przyciskPrawo.style.borderRadius = "5px";
		przyciskPrawo.style.textAlign = "center";
		przyciskPrawo.style.color = "white";
		przyciskPrawo.innerHTML = "Usuń";
		przyciskPrawo.onclick = function(){
			this.parentElement.remove();
			liczbaPolew--;
		}
		document.getElementById("dodanyElementPolewy"+liczbaLodow+polewa).appendChild(przyciskPrawo);

	}
}

//funckja anulujaca dodanie loda
function anulujLoda(){
	liczbaSmakow = 0;
	liczbaDekoracji = 0;
	liczbaPolew = 0;
	document.querySelector("#zamowienieForm").style.display = "block";
	document.querySelector(".choose-window").style.display = "none";
	document.querySelector(".btn-dodaj-loda").style.display = "block";
	document.querySelector(".btn-anuluj-zamowienie").style.display = "block";
	document.querySelector(".btn-zloz-zamowienie").style.display = "block";
	document.getElementById("d"+liczbaLodow+"0").remove();
	document.getElementById("d"+liczbaLodow+"1").remove();
	document.getElementById("d"+liczbaLodow+"2").remove();
	document.getElementById("p"+liczbaLodow+"").remove();
	document.getElementById("l"+liczbaLodow+"").remove();
	tescik[0]="";
	tescik[1]="";
	liczbaLodow--;
	isTasteSet = false;
	
}
//funckja zatwierdzajaca loda do realizacji
function zatwierdzLoda(){
	if(isTasteSet){
		document.querySelector("#zamowienieForm").style.display = "block";
		document.querySelector(".choose-window").style.display = "none";
		document.querySelector(".btn-dodaj-loda").style.display = "block";
		document.querySelector(".btn-anuluj-zamowienie").style.display = "block";
		document.querySelector(".btn-zloz-zamowienie").style.display = "block";
		liczbaSmakow = 0;
		liczbaDekoracji = 0;
		liczbaPolew = 0;
		tescik[0]="";
		tescik[1]="";
		isTasteSet = false;
		$(".smak"+liczbaLodow).remove();
		$(".deko"+liczbaLodow).remove();
		$(".pole"+liczbaLodow).remove();
		pokazPrzyciskUsun();
	}
}
//funckja dodajaca przycisk ktory umozliwia usuwanie calego loda
function pokazPrzyciskUsun(){
	
	var przyciskUsun = document.createElement("div");
		przyciskUsun.style.backgroundColor = "#f95959";
		przyciskUsun.className = "col-4";
		przyciskUsun.setAttribute("id", "usunbtn"+liczbaLodow);
		przyciskUsun.className = "u"+liczbaLodow;
		przyciskUsun.style.marginBottom = "10px";
		przyciskUsun.style.borderRadius = "5px";
		przyciskUsun.style.textAlign = "center";
		przyciskUsun.style.color = "white";
		przyciskUsun.innerHTML = "Usuń loda nr: "+liczbaLodow;
		document.getElementById("l"+liczbaLodow).appendChild(przyciskUsun);
		
		przyciskUsun.onclick = function(){
			this.parentElement.remove();
			liczbaSmakow = 0;
			liczbaDekoracji = 0;
			liczbaPolew = 0;
			tescik[0]="";
			tescik[1]="";
			isTasteSet = false;
			liczbaLodow--;
		}
}
//funkcja usuwajaca calego loda
function usunLoda(){
	
}


function wyslijDoBazy(){
	
	//////////////////////////////////////////
	
}



