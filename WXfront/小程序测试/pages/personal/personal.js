// pages/personal/personal.js
Page({

  getStorage:function(){
    wx.getStorage({
      key:'userInfo',
      success(res){
        console.log(res.data)
      }
    })
  },

  ToUserInfo:function(){
    wx.navigateTo({
      url: '../login/register',
    })
  },
  /**
   * 页面的初始数据
   */
  data: {
    userInfo:'',
    parking_id:''
  },


  //获取停车位置信息
  getMessage: function(){
    wx.request({ //SSMSubmit_war_exploded/wxTest2
      url: 'http://192.168.252.248:8080/sendParkingId', // 仅为示例，需填写自己服务器的地址
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
      }
    })

  },



  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    wx.getStorage({
      key:'userInfo',
      success : res =>{
        console.log(res.data)
        this.setData({
            userInfo:res.data
        })
        
      }
    })

    
    
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})