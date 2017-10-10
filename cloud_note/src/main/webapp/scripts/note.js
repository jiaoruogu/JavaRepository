/***
 * 加载普通笔记
 */
function getNormalNoteList(){
	console.log("加载普通笔记");
}

/***
 * 查询普通笔记内容
 */
function getNoteDetail(){
	console.log("查询普通笔记内容");
}

/***
 * 创建普通笔记
 */
function createNormalNote(){
	alert("创建普通笔记");
}

/***
 * 更新普通笔记
 */
function updateNormalNote(){
	alert("更新普通笔记");
}

/***
 * 删除普通笔记
 */
function deleteNormalNote(){
	var $li=$('#note_ul a.checked').parent();
	var noteId=$li.data("noteId");
	$.ajax({
		url:path+"/note/delete.do",
		data:{"noteId":noteId},
		type:"post",
		dataType:"json",	
		success:function(){
			console.log("shanchuchenggong")
			$li.remove();
			alert("删除笔记成功！");
		},
		error:function(){
			alert("删除笔记失败");
		}
	});
}

/***
 * 移动笔记
 */
function moveNote(){
	alert("移动笔记");
}

/***
 * 分享笔记
 */
function createShareNote(){
	$("footer div strong").text("分享成功").parent().fadeIn(100);
	setTimeout(function(){
		$("footer div").fadeOut(500);
	}, 1500);
}

/***
 * 查询回收站笔记列表
 */
function getRecycleNoteList(){
	var userId=getCookie("userId");
	console.log(userId);
	$.ajax({
		url:path+"/load/receive.do",
		data:{"userId":userId},
		type:"post",	
		dataType:"json",	
		success:function(result){
			if(result.status==0){
				var notes=result.data;
				for(var i=0;i<notes.length;i++){
					var note=result.data[i];
					var noteTitle=note.cn_note_title;
					var noteId=note.cn_note_id;
					var nli='<li class="disable"><a ><i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i> '+noteTitle+'<button type="button" class="btn btn-default btn-xs btn_position btn_delete"><i class="fa fa-times"></i></button><button type="button" class="btn btn-default btn-xs btn_position_2 btn_replay"><i class="fa fa-reply"></i></button></a></li>';			
					var $li=$(nli);
					$li.data("noteId",noteId);
					$('#receive_note').append($li);
					
				}
			}
		},	
		error:function(){
			alert("加载回收站笔记失败！");
		}	
			
	});
}

/***
 * 查看回收站笔记内容
 */
function getRecycleNoteDetail() {
	console.log("查看回收站笔记内容");
}

/***
 * 删除回收站笔记
 */
function deleteRecycleNote(){
	alert("删除回收站笔记");
}

/***
 * 搜索分享笔记列表
 */
function getShareNoteList(){
	alert("搜索分享笔记列表");
}

/***
 * 查询分享笔记内容
 */
function getShareNoteDetail(){
	alert("查询分享笔记内容");
}

/***
 * 收藏分享笔记
 */
function likeShareNote(shareId,dom){
	alert("收藏分享笔记");
}

/***
 * 加载收藏笔记
 */
function getLikeNoteList(likeNoteId){
	alert("加载收藏笔记");
}

/***
 * 查看收藏笔记内容
 */
function getLikeNoteDetail(noteId) {
	console.log("查看收藏笔记内容");
}

/***
 * 删除收藏笔记
 */
function deleteLikeNote(noteId,dom){
	alert("删除收藏笔记");
}

/***
 * 加载本用户参加活动笔记列表
 */
function getNoteActivityList(noteBookId){
	alert("加载本用户参加活动笔记列表");
}

/***
 * 查询参加活动的笔记内容
 */
function getActivityNoteDetail(noteId) {
	console.log("查询参加活动的笔记内容");
}