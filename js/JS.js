function myfunction(){
    var data = [
    {
    "id": 1,
    "name": "Bruce Wayne",
    "subject1": 80,
    "subject2": 45,
    "subject3":90
    },
    {
    "id": 2,
    "name": "Diana",
    "subject1": 56,
    "subject2": 74,
    "subject3":78
    },
    {
    "id": 3,
    "name": "Clark Kent",
    "subject1": 67,
    "subject2": 78,
    "subject3":90
    },
    {
    "id": 4,
    "name": "Barry Allen",
    "subject1": 89,
    "subject2": 35,
    "subject3":64
    },
    {
    "id": 5,
    "name": "Arthur Curry",
    "subject1": 76,
    "subject2": 65,
    "subject3":100
    },
    {
    "id": 6,
    "name": "Victor Stone",
    "subject1": 99,
    "subject2": 87,
    "subject3":64,
    }
    ]

    data.forEach((element) => {
                  element.MaxMarks = Math.max( element.subject1 ,element.subject2 ,element.subject3 );
                });
                
    var table = document.getElementById("myTable");
    var header = table.createTHead();
    var row = header.insertRow(0);
    var head_row = data[0];
    for (let key in head_row) { 
                    i = 0
                    if (head_row.hasOwnProperty(key)) 
                    { 
                      var cell = row.insertCell(-1);
                      i = i+1;
                      cell.innerHTML = key;
                    } 
                }
     
    data.forEach((element) => { 
                    
                    var row = table.insertRow(-1);
                    i = 0
                    for (let key in element) { 
                    if (element.hasOwnProperty(key)) 
                    { 
                      var cell = row.insertCell(i);
                      i = i+1;
                      cell.innerHTML = element[key];
                    } 
                } });}