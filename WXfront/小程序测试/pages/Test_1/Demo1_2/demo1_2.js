var num = '';
Page({
  data:{
    nums:[1,2,3,22,11,23,42,56],
    hour:"",
    minute:"",
    second:"",
    time:""
  },
  
  getNum(event){
    console.log(event.detail.value)
    num = event.detail.value
  },

  add(){
    var numNew =[]
    numNew = this.data.nums
    numNew.push(num)
    
    this.setData({
      nums:numNew
    })
  },

  delete(){
    var arr = this.data.nums
    var numsNew = []
   
    for(var i=0;i<arr.length;i++){
      if(arr[i] != num){
        numsNew.push(arr[i])
      }
    }
    console.log(numsNew)
    this.setData({
      nums:numsNew
    })
    console.log(num)
  },

  timing:function(e){
    var time = setTimeout(function(){
      e.setData({time:e.data.second +1});
      e.timing(e);
    },1000)

    // this.setData({
    //   time:time
    // })
  },

  onLoad(){
    this.timing(this)
    var dateNow = new Date()
    var target = new Date(2021,9,27,23)
    console.log(target)
    var time = target.getTime() - dateNow.getTime()
    var second = Math.ceil(time/1000%60)
    var minute = parseInt(time/1000/60%60)
    var hour = parseInt(time/1000/60/60%24)

    console.log(hour+":"+minute+":"+second)
    this.setData({
      hour:hour,
      minute:minute,
      second:second
    })

  }
})