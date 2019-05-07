        $(document).ready(function () {
            $('#sidebarCollapse').on('click', function () {
                $('#sidebar').toggleClass('active');
                $(this).toggleClass('active');
            });

            $('#submitProposal').on('submit', function() {
                $(this).each(function() {
                     this.reset();
                });
            });

        });


