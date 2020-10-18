### https://registry.npmjs.org/

## 1 加减日期 addDate() 

```
/**
 * 
 * @param {Date} date Date数据类型
 * @param {Number} days 整型数据
 */
function addDate(date,days){
    var d=new Date(date);
    d.setDate(d.getDate()+days);
    var month=d.getMonth()+1;
    var day = d.getDate();
    if(month<10){
        month = "0"+month;
    }
    if(day<10){
        day = "0"+day;
    }
    var val = d.getFullYear()+"-"+month+"-"+day;
    return val;
}
```

## 2 变成百分数

```
/**
 * 
 * @param {Number} point 数字
 */
function toPercent(point) {
    var str = Number(point * 100).toFixed(2);
    str += "%";
    return str;
}
```

## js函数

 parseInt() ---> 相当于java的 int整除  
 
 Number(total/24).toFixed(0)  
 