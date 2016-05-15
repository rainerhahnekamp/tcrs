var gulp = require('gulp'),
  paths = require('./paths'),
  sass = require('gulp-sass');

gulp.task('sass', function() {
  return gulp.src(paths.sass)
    .pipe(sass())
    .pipe(gulp.dest(paths.bundle));
});
