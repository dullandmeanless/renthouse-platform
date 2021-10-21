// pages/login/register.js
const api = require('../../utils/api.js').api


Page({
  data: {
     carId:null,
     userName:null,
     phone:null,
     url:api
  },

  // 从文本框中获取用户输入数据
  carIdText:function(event){
    var cardId = event.detail.value;
    this.setData({
      carId:cardId,
    })
    console.log(this.data.carId)
  },

  userNameText:function(event){
    var userName = event.detail.value;
    this.setData({
      userName:userName,
    })
    console.log(this.data.userName)
  },

  phoneNumText:function(event){
    var phone = event.detail.value;
    this.setData({
      phone:phone,
    })
    console.log(this.data.phone)
  },
  submit:function(){
    wx.request({
      url: 'http://172.23.63.249:8080/getUserInfo',
      data:{
        car_number:this.data.carId,
        host_name:this.data.userName,
        phone:this.data.phone
      },
      header: {
        // 'content-type': 'application/json' // 默认值
         'Content-Type': 'application/x-www-form-urlencoded'
       },
       method:'POST',
       success: res =>{
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

    wx.switchTab({
      url: '../main/main',
    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
      console.log(this.data.url)
  },


})