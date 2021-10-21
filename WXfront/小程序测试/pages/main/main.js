var util = require('../../utils/util');

Page({
  mixins: [require('../mixin/themeChanged')],
  
  data: {
    isPark:false,
    timein:'',
    money:'',
    parking_id:'',
    h:'00',m:'00',s:'00',setInter:'',
    ParkButtonText:"我要入库",
    cardCur: 0,
    swiperList: [{
      id: 1,
      type: 'image',
      url: 'http://bpic.588ku.com/element_origin_min_pic/16/12/28/9176edee1fc9d76e408cac7a5441ec33.jpg'
    }, {
      id: 0,
        type: 'image',
        url: 'https://tse1-mm.cn.bing.net/th/id/R-C.0c1b68cbb7876535136480b851591914?rik=uFXl3yfTLSIr8w&riu=http%3a%2f%2fupic.jiancai.com%2fupload%2fuser%2fmdjl%2f2013316174749965.jpg&ehk=%2faOuMP%2b1ieoPi%2fqe9nXpD%2bDyHQyVvEbXoAT3oDNp5kU%3d&risl=&pid=ImgRaw&r=0',
    },{
      id:2,
      type:'image',
      url:'',
    }
  
  ],
  },

  //设置秒数数每秒加一
  timing: function (e) {
    var time = setTimeout(function () {
      e.setData({second: e.data.second + 1});
      e.timing(e);
    } , 1000)

  },


  onclick:function(){
    if(!this.data.isPark){
      let timein = Date.parse(new Date());
      console.log(timein/1000)

      const that = this;
      var hou=that.data.h
      var min=125
      var sec=that.data.s

      that.data.setInter  = setInterval(function(){
        sec++
        if(sec>=60){
         sec=0
         min++
         if(min>=60){
           min=0
           hou++
           that.setData({
             h:(hou<10?'0'+min:min)
           })
         }else{
           that.setData({
             m:(min<10?'0'+min:min)
           })
         }
        }else{
          that.setData({
            s:(sec<10?'0'+sec:sec)
          })
        }
      
          var numVal = that.data.num + 1;
          that.setData({ num: numVal });
          console.log('setInterval==' + that.data.num);
    
      },1000)
      //显示出库按钮
      this.setData({
        isPark:true,
        timein:timein,
        ParkButtonText:"我要出库"
      })
    }else{
      wx.request({ //SSMSubmit_war_exploded/getParkTime
        url: 'http://192.168.252.248:8080/getTimeSendMoney',
        data:{
          parking_id:this.data.parking_id,//测试使用的停车位
          hour:this.data.h,
          min:120,
          second:this.data.s
        },
        header: {
          // 'content-type': 'application/json' // 默认值
           'Content-Type': 'application/x-www-form-urlencoded'
         },
         method:'POST',
         success: res =>{
            console.log('第一个')
            wx.showToast({
              title: '后端已接收',
            })
         },
         fail: res=>{
          wx.showToast({
            title: '提交失败',
          })
        }
      })
      clearInterval(this.data.setInter)
      this.setData({
        isPark:false,
        h:'00',
        m:'00',
        s:'00',
        ParkButtonText:"我要入库"
      })

      //成功获取数据后 后端计算停车费返回结果
      wx.request({ //SSMSubmit_war_exploded/wxTest2
        url: 'http://192.168.252.248:8080/sendMoney', // 仅为示例，需填写自己服务器的地址
        method:"POST",
        dataType:'json',
        data: {
           money:this.data
        },

        //获取后台计算出来的停车费
        success: (res) =>{
          console.log("停车费共计："+res.data)     //打印到控制台
          console.log('第2个')
          this.setData({
            money:res.data.money
          })
          
        },

      })
    }
  },

  carIn:function(){
    let timein = Date.parse(new Date());
    console.log(timein/1000)

    const that = this;
    var hou=that.data.h
    var min=125
    var sec=that.data.s

    that.data.setInter  = setInterval(function(){
      sec++
      if(sec>=60){
       sec=0
       min++
       if(min>=60){
         min=0
         hou++
         that.setData({
           h:(hou<10?'0'+min:min)
         })
       }else{
         that.setData({
           m:(min<10?'0'+min:min)
         })
       }
      }else{
        that.setData({
          s:(sec<10?'0'+sec:sec)
        })
      }
    
        var numVal = that.data.num + 1;
        that.setData({ num: numVal });
        console.log('setInterval==' + that.data.num);
  
    },1000)
    //显示出库按钮
    this.setData({
      isPark:true,
      timein:timein,
      ParkButtonText:"我要出库"
    })
  },

  carOut:function(){
    
    wx.request({ //SSMSubmit_war_exploded/getParkTime
      url: 'http://192.168.118.231:8080/getTimeSendMoney',
      data:{
        parking_id:this.data.parking_id,//测试使用的停车位
        hour:this.data.h,
        min:120,
        second:this.data.s
      },
      header: {
        // 'content-type': 'application/json' // 默认值
         'Content-Type': 'application/x-www-form-urlencoded'
       },
       method:'POST',
       success: res =>{
          console.log('第一个')
          wx.showToast({
            title: '后端已接收',
          })
          //成功获取数据后 后端计算停车费返回结果
          wx.request({ //SSMSubmit_war_exploded/wxTest2
            url: 'http://192.168.118.231:8080/sendMoney', // 仅为示例，需填写自己服务器的地址
            method:"POST",
            dataType:'json',
            data: {
              money:this.data
            },

            //获取后台计算出来的停车费
             success: (res) =>{
            console.log("停车费共计："+res.data)     //打印到控制台
            console.log('第2个')
            this.setData({
              money:res.data.money
            })
        
            },

          })
       },
       fail: res=>{
        wx.showToast({
          title: '提交失败',
        })
      }
    })



    //将时间设置为00:00:00
    clearInterval(this.data.setInter)
    this.setData({
      isPark:false,
      h:'00',
      m:'00',
      s:'00',
      ParkButtonText:"我要入库"
    })
  },

  onLoad() {
    this.towerSwiper('swiperList');// 初始化towerSwiper 传已有的数组名即可
    
    this.timing(this)//初始化时间秒

    wx.request({ //SSMSubmit_war_exploded/wxTest2
      url: 'http://172.23.63.249:8080/sendParkingId', // 仅为示例，需填写自己服务器的地址
      method:"POST",
      dataType:'json',
      data: {
         parking_id:this.data.parking_id
      },

      success:(res)=>{
        console.log(res.data);      //打印到控制台
        this.setData({
            parking_id:res.data //发送到wxml
        })
        wx.setStorage({
          key:'parking_id',
          value:res.data
        })
      }
    })
  },
  DotStyle(e) {
    this.setData({
      DotStyle: e.detail.value
    })
  },
  // cardSwiper
  cardSwiper(e) {
    this.setData({
      cardCur: e.detail.current
    })
  },
  // towerSwiper
  // 初始化towerSwiper
  towerSwiper(name) {
    let list = this.data[name];
    for (let i = 0; i < list.length; i++) {
      list[i].zIndex = parseInt(list.length / 2) + 1 - Math.abs(i - parseInt(list.length / 2))
      list[i].mLeft = i - parseInt(list.length / 2)
    }
    this.setData({
      swiperList: list
    })
  },
  // towerSwiper触摸开始
  towerStart(e) {
    this.setData({
      towerStart: e.touches[0].pageX
    })
  },
  // towerSwiper计算方向
  towerMove(e) {
    this.setData({
      direction: e.touches[0].pageX - this.data.towerStart > 0 ? 'right' : 'left'
    })
  },
  // towerSwiper计算滚动
  towerEnd(e) {
    let direction = this.data.direction;
    let list = this.data.swiperList;
    if (direction == 'right') {
      let mLeft = list[0].mLeft;
      let zIndex = list[0].zIndex;
      for (let i = 1; i < list.length; i++) {
        list[i - 1].mLeft = list[i].mLeft
        list[i - 1].zIndex = list[i].zIndex
      }
      list[list.length - 1].mLeft = mLeft;
      list[list.length - 1].zIndex = zIndex;
      this.setData({
        swiperList: list
      })
    } else {
      let mLeft = list[list.length - 1].mLeft;
      let zIndex = list[list.length - 1].zIndex;
      for (let i = list.length - 1; i > 0; i--) {
        list[i].mLeft = list[i - 1].mLeft
        list[i].zIndex = list[i - 1].zIndex
      }
      list[0].mLeft = mLeft;
      list[0].zIndex = zIndex;
      this.setData({
        swiperList: list
      })
    }
  }
});