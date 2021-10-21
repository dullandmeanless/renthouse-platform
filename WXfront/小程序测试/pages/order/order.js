// pages/order/order.js
Page({
  mixins: [require('../mixin/themeChanged')],
  data: {
      carNum:150,
      unUse:99,
      date: '2021-10-12',
      time: '12:00'
  },
  bindPickerChange: function(e) {
      console.log('picker发送选择改变，携带值为', e.detail.value)
      this.setData({
          index: e.detail.value
      })
  },
  bindDateChange: function(e) {
      console.log('选择日期发生变化，值为：',e.detail.value)
      this.setData({
          date: e.detail.value
      })
  },
  bindTimeChange: function(e) {
    console.log('选择时间发生变化，值为：',e.detail.value)
      this.setData({
          time: e.detail.value
      })
  },
  showModal(e) {
    this.setData({
      modalName: e.currentTarget.dataset.target
    })
  },
  hideModal(e) {
    this.setData({
      modalName: null
    })
  },

})