<template>
    <div class="middle">
        <Sidebar :users="users" :posts="posts"/>
        <main>
            <Index :users="users" :posts="posts" v-if="page === 'Index'"/>
            <Users :users="users" v-if="page === 'Users'"/>
            <Enter v-if="page === 'Enter'"/>
            <Register v-if="page === 'Register'"/>
            <AddPost v-if="page === 'AddPost'"/>
            <EditPost v-if="page === 'EditPost'"/>
            <PostView :post="curPost" :users="users" v-if="page === 'PostView'"/>

        </main>
    </div>
</template>
<script>
    import Index from './middle/Index';
    import Enter from './middle/Enter';
    import Register from './middle/Register';
    import AddPost from './middle/AddPost';
    import Sidebar from './middle/Sidebar'
    import EditPost from "./middle/EditPost";
    import Users from "./middle/Users";
    import PostView from "./middle/PostView";

    export default {
        name: "Middle",
        props: ['users', 'posts'],
        data: function () {
            return {
                page: "Index",
                curPost: undefined
            }
        },

        components: {
            PostView,
            EditPost,
            Index,
            Enter,
            Register,
            Sidebar,
            AddPost,
            Users
        },
        beforeCreate() {
            this.$root.$on("onChangePage", (page) => {
                this.page = page;
            });
            this.$root.$on("onViewPost", (postId) => {
                this.page = "PostView";
                this.curPost = this.posts[postId];
            });
        }
    }
</script>

<style scoped>

</style>
