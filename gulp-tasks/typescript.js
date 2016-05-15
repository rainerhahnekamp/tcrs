var gulp = require('gulp'),
  changed = require('gulp-changed'),
  paths = require('./paths'),
  plumber = require('gulp-plumber'),
  sourcemaps = require('gulp-sourcemaps'),
  tap = require('gulp-tap'),
  tslint = require('gulp-tslint'),
  tsc = require('gulp-typescript');

gulp.task('typescript', function() {
  return gulp.src(paths.tsSource)
    .pipe(changed(paths.bundle, {extension: '.ts'}))
    .pipe(tslint({tslint: require('tslint')}))
    .pipe(tslint.report('prose'))
    .pipe(sourcemaps.init())
    .pipe(tsc({
      "target": "es5",
      "module": "system",
      "moduleResolution": "node",
      "sourceMap": true,
      "emitDecoratorMetadata": true,
      "experimentalDecorators": true,
      "removeComments": false,
      "noImplicitAny": true,
      "suppressImplicitAnyIndexErrors": true
    }))
    .pipe(sourcemaps.write(paths.bundle))
    .pipe(gulp.dest(paths.bundle))
});
