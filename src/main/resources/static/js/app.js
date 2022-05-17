$(document).ready(() =>{
    $('.delete-bt').on('click', function () {
        const id = $(this).attr('data-id');

        if(confirm("Are you sure you want to delete post?")){
            document.location.replace('/posts/delete/' + id);
        }

    });
});
