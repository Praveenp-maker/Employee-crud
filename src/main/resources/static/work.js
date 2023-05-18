function findall(){
	    console.log("enter into findall");
    $.ajax({
        url: "http://localhost:8080/employee/list",
        type: "GET",
        dataType: "json",
        contentType:"application/json",
        success: function (data) {
            console.log("success");
            console.log(data);
           
             displayItems(data);
       

        },
        error: function (error) {
            console.log(`Error ${error}`);
        },
    });
}
	
	function tovalues(){
		location.href="values.html";
	}
	function add(){
		location.href="add.html";
	}
	
	function addvalues(){
		console.loh("inside add values");
		   var newitem = {
           "Empid": document.getElementById("empid").value,
           "Age": document.getElementById("age").value,
           "Experience": document.getElementById("experience").value,
           "Name": document.getElementById("name").value,
           "Native": document.getElementById("native").value,
           "Role": document.getElementById("role").value,
       
   
       }
       console.log(newitem);
       $.ajax({
           type: "POST",
           url: "http://localhost:8080/employee/addEmployees",
           data: JSON.stringify(newitem),
           contentType:"application/json",
           success: function (result) {
               //getAll();
               console.log("sucesss");
               
               //getnew();
           },
           error: function (result) {
               alert("msg");
           },
       });
   
   }
		
		
		function displayItems(data){

    //location.href="viewer.html";
      const tEvent = document.getElementById("event");
 console.log(tEvent);
    const button = document.createElement("button");

  data.forEach((item) => {

          let editButton = button.cloneNode(false);
    editButton.innerText = "Edit";
    editButton.setAttribute("onclick", `editItem(${item.empid})`);
    
       let deleteButton = button.cloneNode(false);
    deleteButton.innerText = "delete";
    deleteButton.setAttribute("onclick", `deleteItem(${item.empid})`);

        let tr = tEvent.insertRow();

        let td1 = tr.insertCell(0);
        let Empid = document.createTextNode(item.empid);
        td1.appendChild(Empid);

        let td2 = tr.insertCell(1);
        let Name = document.createTextNode(item.name);
        td2.appendChild(Name);

        let td3 = tr.insertCell(2);
        let Role = document.createTextNode(item.role);
        td3.appendChild(Role);

        let td4 = tr.insertCell(3);
        let Age = document.createTextNode(item.age);
        td4.appendChild(Age);

        let td5 = tr.insertCell(4);
        let Native = document.createTextNode(item.native);
        td5.appendChild(Native);

        let td6 = tr.insertCell(5);
        let Experience = document.createTextNode(item.experience);
        td6.appendChild(Experience);

         let td7= tr.insertCell(6);
        td7.appendChild(editButton);
        
          let td8= tr.insertCell(7);
        td8.appendChild(deleteButton);

    });
   
    
}
	function deleteItem(empid){
		console.log(empid)
		    $.ajax({
        url: "http://localhost:8080/employee/EmpPojo",
        type: "DELETE",
        dataType: "json",
        contentType:"application/json",
        success: function (data) {
            console.log("success");
            console.log(data);
           
             displayItems(data);
       

        },
        error: function (error) {
            console.log(`Error ${error}`);
        },
    });
}
	